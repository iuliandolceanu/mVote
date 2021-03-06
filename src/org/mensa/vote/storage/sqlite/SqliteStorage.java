package org.mensa.vote.storage.sqlite;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.mensa.vote.model.Candidature;
import org.mensa.vote.model.Member;
import org.mensa.vote.model.Vote;
import org.mensa.vote.storage.StorageFacade;

/**
 * Implementation of {@link StorageFacade} that provides functionality via
 * SQLite.
 */
public class SqliteStorage implements StorageFacade {

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
     * Closes connection to database.
     * {@inheritDoc}
     *
     * @throws SQLException
     *             in case {@link Connection} cannot be closed.
     */
    @Override
    public void close() throws SQLException {
        SqliteAdapter.getInstance().close();
    }
}
