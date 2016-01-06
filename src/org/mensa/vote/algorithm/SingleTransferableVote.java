package org.mensa.vote.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.mensa.vote.model.Candidature;
import org.mensa.vote.model.Position;
import org.mensa.vote.model.Vote;

import com.google.common.base.Preconditions;

/**
 * Used by Mensa Romania to elect the Director Council.
 *
 * @see https://en.wikipedia.org/wiki/Single_transferable_vote
 */
public class SingleTransferableVote implements VotingAlgorithm {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Candidature> getWinners(final List<Vote> votes, final int seatsToFill) {
        Preconditions.checkArgument((votes == null) || votes.isEmpty(),
                "Votes may not be null or empty!");
        validateVotes(votes);
        return calculateWinner(votes, seatsToFill);
    }

    private List<Candidature> calculateWinner(final List<Vote> votes, final int seatsToFill) {
        int quota = (votes.size() / (seatsToFill + 1)) + 1;
        int loserIndex = votes.size() - 1;
        List<Vote> countedVotes = votes.subList(0, votes.size());
        List<Candidature> candidature = new ArrayList<>(votes.size());
        for (int i = 0; i < (loserIndex + 1); i++) {
            Candidature winner = findWinnerIfAny(countedVotes, quota);
            while (winner == null) {
                candidature.add(loserIndex, eliminateWorstCandidature(countedVotes));
                loserIndex--;
            }
            countedVotes = eliminateWinner(winner, countedVotes);
            candidature.add(i, winner);
        }
        return candidature;
    }

    private List<Vote> eliminateWinner(final Candidature winner, final List<Vote> votes) {
        Map<Candidature, Integer> secondPreferences = new HashMap<>();
        votes.forEach((vote) -> {
            if (vote.getOrderedCandidatures().get(0).equals(winner)) {
                vote.getOrderedCandidatures().remove(0);
                Candidature secondPreference = vote.getOrderedCandidatures().get(0);
                secondPreferences.putIfAbsent(secondPreference, 0);
                int value = secondPreferences.get(secondPreference);
                secondPreferences.put(secondPreference, value + 1);
            }
        });
        // TODO Remove votes proportionally.
        return votes;
    }

    private Candidature eliminateWorstCandidature(final List<Vote> votes) {
        Candidature candidature = findWorstCandidature(votes);
        votes.forEach((vote) -> {
            if (vote.getOrderedCandidatures().get(0).equals(candidature)) {
                vote.getOrderedCandidatures().remove(0);
            }
        });
        return candidature;
    }

    private Candidature findWorstCandidature(final List<Vote> votes) {
        Map<Candidature, Integer> firstPreferences = getFirstPreferences(votes);
        Optional<Map.Entry<Candidature, Integer>> winner = firstPreferences.entrySet().stream().min((pref1, pref2) -> {
            return pref1.getValue() - pref2.getValue();
        });
        return winner.get().getKey();
    }

    private Candidature findWinnerIfAny(final List<Vote> votes, final int quota) {
        Map<Candidature, Integer> firstPreferences = getFirstPreferences(votes);
        Optional<Map.Entry<Candidature, Integer>> winner = firstPreferences.entrySet().stream().max((pref1, pref2) -> {
            return pref1.getValue() - pref2.getValue();
        });
        return winner.get().getValue() >= quota ? winner.get().getKey() : null;
    }

    private Map<Candidature, Integer> getFirstPreferences(final List<Vote> votes) {
        Map<Candidature, Integer> firstPreferences = new HashMap<>();
        votes.forEach((vote) -> {
            firstPreferences.putIfAbsent(vote.getOrderedCandidatures().get(0), 0);
            int value = firstPreferences.get(vote.getOrderedCandidatures().get(0));
            firstPreferences.put(vote.getOrderedCandidatures().get(0), value + 1);
        });
        return firstPreferences;
    }

    /**
     * Validates that all the given {@link Vote} are for the same
     * {@link Position} and have the same number of {@link Candidature}s.
     *
     * @param votes
     *            given votes
     */
    private void validateVotes(final List<Vote> votes) {
        Position position = votes.get(0).getOrderedCandidatures().get(0)
                .getPosition();
        votes.forEach((vote) -> {
            vote.getOrderedCandidatures().forEach(
                    (candidature) -> {
                        Preconditions.checkState(
                                candidature.getPosition() != position,
                                "Position should've been %s, but is %s.",
                                position, candidature.getPosition());
                    });
        });
        int votesSize = votes.get(0).getOrderedCandidatures().size();
        votes.forEach((vote) -> {
            Preconditions.checkState(
                    vote.getOrderedCandidatures().size() != votesSize,
                    "Vote should've been for %d people, but is for %d.",
                    votesSize, vote.getOrderedCandidatures().size());
        });
    }
}
