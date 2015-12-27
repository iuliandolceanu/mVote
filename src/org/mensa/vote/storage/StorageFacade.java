package org.mensa.vote.storage;

import java.util.List;

import org.mensa.vote.model.Candidate;
import org.mensa.vote.model.Member;
import org.mensa.vote.model.Vote;

/**
 * Contract between the service and the database.
 */
public interface StorageFacade {

    /**
     * Adds a candidate to the database.
     *
     * @param candidate
     *            {@link Candidate} to be added to the database
     */
    public void addCandidate(final Candidate candidate);

    /**
     * Removes the given candidate from the database.
     *
     * @param candidateId
     *            the id of the {@link Candidate} to be removed
     */
    public void removeCandidate(final String candidateId);

    /**
     * Returns a candidate by the given Id.
     *
     * @param candidateId
     *            {@link Candidate}'s id
     * @return the corresponding {@link Candidate} record
     */
    public Candidate viewCandidate(final String candidateId);

    /**
     * Adds a vote to the database.
     *
     * @param vote
     *            adds a {@link Vote} to the database
     */
    public void castVote(final Vote vote);

    /**
     * Returns the complete {@link List} of {@link Vote}s.
     *
     * @return ordered {@link List} of {@link Vote}s
     */
    public List<Vote> listVotes();

    /**
     * Adds a {@link Member} with voting rights.
     *
     * @param member
     *            {@link Member} to be added
     */
    public void addMember(final Member member);

    /**
     * Removes a {@link Member} from the database.
     *
     * @param memberId
     *            id of the {@link Member} to be removed
     */
    public void removeMember(final String memberId);
}
