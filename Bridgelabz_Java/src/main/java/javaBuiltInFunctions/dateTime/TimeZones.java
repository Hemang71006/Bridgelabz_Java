package javaBuiltInFunctions.dateTime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Problem 1: Time Zones and ZonedDateTime
 * Display the current time in GMT, IST, and PST.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */

public class TimeZones {

    public static void main(String[] args) {

        // Get the current date and time for each time zone
        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));
        ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime pstTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

        // Display the times
        System.out.println("GMT Time: " + gmtTime);
        System.out.println("IST Time: " + istTime);
        System.out.println("PST Time: " + pstTime);
    }
}
