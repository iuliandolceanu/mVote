package org.mensa.vote.model;

import lombok.Builder;
import lombok.Value;

/**
 * Represents a candidate.
 */
@Value
@Builder
public class Candidature {

    /** Every candidate must be a voting {@link Member}. This field stores all the membership data, like the name and ID. */
    private final Member member;

    /** {@link Position} for which a {@link Member} is candidating. */
    private final Position position;
}
