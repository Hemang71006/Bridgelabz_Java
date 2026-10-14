package javaCollections.javaCollectionApplications;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Problem 1 (Collections - Voting System)
 * Store votes using HashMap, preserve vote order using LinkedHashMap,
 * and display results in sorted candidate order using TreeMap.
 *
 * Author : Hemang
 * Date   : 12-10-2026
 */

public class VotingSystem {

    public static void main(String[] args) {

        // Store total votes for each candidate
        Map<String, Integer> votes = new HashMap<>();

        // Maintain the order in which votes are recorded
        Map<String, Integer> voteOrder = new LinkedHashMap<>();

        // Record votes
        String[] candidates = {"Aman", "Riya", "Aman", "Karan", "Riya", "Aman"};

        for (String candidate : candidates) {

            // Increase the candidate's vote count
            votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);

            // Preserve the order in which candidates first receive votes
            voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1);
        }

        // Sort results alphabetically by candidate name
        Map<String, Integer> sortedResults = new TreeMap<>(votes);

        System.out.println("Voting Results:");

        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }

        // Find the candidate with the highest vote count
        String winner = null;
        int highestVotes = -1;

        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > highestVotes) {
                highestVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        System.out.println("Winner: " + winner);
    }
}
