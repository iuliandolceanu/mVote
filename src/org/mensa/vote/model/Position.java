package org.mensa.vote.model;

import com.google.common.base.Preconditions;

public enum Position {
    PRESIDENT(1), SECRETARY(1), TREASURER(1), MEMBER(4);

    private final int numberOfPositions;

    private Position(final int numberOfPositions) {
        Preconditions.checkArgument(numberOfPositions > 0,
                "The number of positions has to be greater than 0.");
        this.numberOfPositions = numberOfPositions;
    }

    /**
     * Returns the number of available positions for the current position.
     *
     * @return The number of current positions
     */
    public int getNumberOfPositions() {
        return numberOfPositions;
    }
}
