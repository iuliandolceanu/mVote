package org.mensa.vote.storage.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Used to wrap around the Sqlite API, and handle internals.
 */
public class SqliteAdapter {

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

    /**
     * Constructor. Connects service to SQLite database.
     */
    private SqliteAdapter() {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
