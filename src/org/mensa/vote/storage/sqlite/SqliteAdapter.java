package org.mensa.vote.storage.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Used to wrap around the Sqlite API, and handle internals.
 */
public class SqliteAdapter implements AutoCloseable {

    /** The URL to the SQLite DB. */
    private static final String SQLITE_DB_URL = "jdbc:sqlite:test.db";

    /**
     * Singleton instance holder. We want eager initialization to fail fast at
     * service startup in case of failure.
     */
    private static final SqliteAdapter INSTANCE = new SqliteAdapter();

    /**
     * Returns singleton instance of {@link SqliteAdapter}.
     *
     * @return singleton instance of {@link SqliteAdapter}.
     */
    public static SqliteAdapter getInstance() {
        return INSTANCE;
    }

    private Connection connection;

    /**
     * Constructor. Connects service to SQLite database.
     */
    private SqliteAdapter() {
        connection = createConnection(SQLITE_DB_URL);
        try {
            initializeTablesIfNone();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates a DB {@link Connection} to the given URL.
     *
     * @param url
     *            the DB's URL
     * @return A {@link Connection} to the given URL
     */
    private Connection createConnection(final String url) {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(url);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void initializeTablesIfNone() throws SQLException {
        executeUpdate("CREATE TABLE IF NOT EXISTS MEMBERS "
                + "(ID TEXT PRIMARY KEY NOT NULL, "
                + "NAME TEXT NOT NULL, "
                + "EMAIL TEXT NOT NULL, "
                + "TOKEN TEXT NOT NULL, "
                + "PASSHASH TEXT NOT NULL, " + "VOTED BOOLEAN NOT NULL)");
        executeUpdate("CREATE TABLE IF NOT EXISTS CANDIDATES "
                + "(ID TEXT PRIMARY KEY NOT NULL, "
                + "POSITIONS TEXT NOT NULL) ");
        executeUpdate("CREATE TABLE IF NOT EXISTS VOTES "
                + "(ID TEXT PRIMARY KEY NOT NULL, "
                + "MEMBER_ID TEXT FOREIGN KEY NOT NULL, "
                + "PRESIDENCY_VOTE TEXT NOT NULL, "
                + "TREASURER_VOTE TEXT NOT NULL, "
                + "SECRETARY_VOTE TEXT NOT NULL, "
                + "MEMBER_VOTE TEXT NOT NULL");
    }

    /**
     * Executes DDL and DML SQL queries (e.g.: CREATE, INSERT, DELETE).
     *
     * @param query
     *            query to be run
     * @throws SQLException
     *             if something goes wrong
     */
    private void executeUpdate(final String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
    }

    /**
     * Executes SELECT queries.
     *
     * @param query
     *            query to be run
     * @return the {@link ResultSet} of running the query
     * @throws SQLException
     *             if something goes wrong
     */
    private ResultSet executeQuery(final String query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(query);
        statement.close();
        return results;
    }

    /**
     * Closes connection to database. {@inheritDoc}
     *
     * @throws SQLException
     *             in case the connection cannot be closed.
     */
    @Override
    public void close() throws SQLException {
        connection.close();
    }
}
