package org.mensa.vote.model;

import java.time.Instant;
import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Vote {

    /** Moment of vote. */
    private final Instant voteTime;

    /** Votes ordered by preference. */
    private final List<Candidature> orderedCandidatures;
}
