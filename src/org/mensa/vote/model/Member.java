package org.mensa.vote.model;

import java.util.concurrent.atomic.AtomicBoolean;

import lombok.Builder;
import lombok.Value;

/**
 * Represents a Mensa member.
 */
@Value
@Builder
public class Member {

    /** Mensa unique identification number. */
    private final String id;

    /** Member's name. */
    private final String name;

    /** Member's email address from the Mensa records. */
    private final String email;

    /** Member's authentication token. */
    private final String token;

    /** Hash of the passcode sent via email. */
    private final String passHash;

    /** True if the Member has voted. */
    private final AtomicBoolean voted;
}
