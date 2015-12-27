package org.mensa.vote.model;

import java.time.Instant;
import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Vote {

    /** {@link Member} who has cast the vote. */
    private final Member member;

    /** Moment of vote. */
    private final Instant voteTime;

    /** Vote for the president position. */
    private final List<Candidate> presidentVote;

    /** Vote for the secretary position. */
    private final List<Candidate> secretaryVote;

    /** Vote for the treasurer position. */
    private final List<Candidate> treasurerVote;

    /** Vote for the member position. */
    private final List<Candidate> membersVote;
}
