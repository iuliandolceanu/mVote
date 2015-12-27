package org.mensa.vote.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Constants {

    public static final ZonedDateTime VOTING_START = ZonedDateTime.of(
            LocalDate.of(2016, 3, 30), LocalTime.of(18, 0),
            ZoneId.of("Europe/Bucharest"));
    public static final ZonedDateTime VOTING_END = ZonedDateTime.of(
            LocalDate.of(2016, 4, 10), LocalTime.of(18, 0),
            ZoneId.of("Europe/Bucharest"));

    public static final ZonedDateTime ADD_CANDIDATE_START = ZonedDateTime.of(
            LocalDate.of(2016, 2, 26), LocalTime.of(0, 0),
            ZoneId.of("Europe/Bucharest"));
    public static final ZonedDateTime ADD_CANDIDATE_END = ZonedDateTime.of(
            LocalDate.of(2016, 6, 3), LocalTime.of(23, 59, 59),
            ZoneId.of("Europe/Bucharest"));

    public static final ZonedDateTime REMOVE_CANDIDATE_START = ZonedDateTime
            .of(LocalDate.of(2016, 2, 26), LocalTime.of(0, 0),
                    ZoneId.of("Europe/Bucharest"));
    public static final ZonedDateTime REMOVE_CANDIDATE_END = ZonedDateTime.of(
            LocalDate.of(2016, 6, 3), LocalTime.of(23, 59, 59),
            ZoneId.of("Europe/Bucharest"));
}
