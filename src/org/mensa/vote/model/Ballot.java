package org.mensa.vote.model;

import java.util.Map;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Ballot {

    /** {@link Member} who has cast the vote. */
    private final Member member;

    private final Map<Position, Vote> votes;
}
