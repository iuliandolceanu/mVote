package org.mensa.vote.storage.memory;

import java.util.List;

import org.mensa.vote.model.Candidature;
import org.mensa.vote.model.Member;
import org.mensa.vote.model.Vote;
import org.mensa.vote.storage.StorageFacade;

import com.google.common.annotations.VisibleForTesting;

/**
 * Implementation of {@link StorageFacade} used for testing purposes. Will not
 * write on disk.
 */
@VisibleForTesting
public class InMemoryStorage implements StorageFacade {

    /**
     * {@inheritDoc}
     */
    @Override
    public void addCandidate(final Candidature candidate) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeCandidate(final String candidateId) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Candidature viewCandidate(final String candidateId) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void castVote(final Vote vote) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Vote> listVotes() {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addMember(final Member member) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeMember(final String memberId) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() {
        throw new UnsupportedOperationException();
    }
}
