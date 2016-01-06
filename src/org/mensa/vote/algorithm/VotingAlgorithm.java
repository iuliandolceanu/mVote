package org.mensa.vote.algorithm;

import java.util.List;

import org.mensa.vote.model.Candidature;
import org.mensa.vote.model.Vote;

/**
 * Represents an algorithm used to calculate the winners of an election.
 */
public interface VotingAlgorithm {

    /**
     * Returns a {@link List} of {@link Candidature}s ordered by the performance
     * each of them had according to the implementing algorithm. The best
     * {@link Candidature} will be at index 0.
     *
     * @param votes
     *            a {@link List} of {@link Vote}s to calculate the result of the
     *            voting on
     * @param seatsToFill
     *            number of winning {@link Candidature}s
     * @return the ordered {@link List} of {@link Candidature}s, with the best
     *         performing one at index 0
     */
    List<Candidature> getWinners(List<Vote> votes, int seatsToFill);
}
