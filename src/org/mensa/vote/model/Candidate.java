package org.mensa.vote.model;

import java.util.List;

import lombok.Builder;
import lombok.Value;

/**
 * Represents a candidate.
 */
@Value
@Builder
public class Candidate {

    /** Every candidate must be a voting member. This field stores all the membership data, like the name and ID. */
    private final Member member;

    /** Positions for which a person is candidating. One may be a candidate for multiple positions. */
    private final List<Position> positions;
}
