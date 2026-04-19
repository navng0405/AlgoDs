package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongPairFinder {

    private static int toSeconds(String duration) {
        String[] parts = duration.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    public static List<String> findPair(List<String[]> songs) {
        final int TARGET_DURATION = 7 * 60; // 7 minutes in seconds
        Map<Integer, List<String>> durationToSongsMap = new HashMap<>();

        // Convert durations to seconds and populate the HashMap
        for (String[] song : songs) {
            int durationInSeconds = toSeconds(song[1]);
            durationToSongsMap.computeIfAbsent(durationInSeconds, k -> new ArrayList<>()).add(song[0]);
        }

        for (String[] song : songs) {
            int currentDuration = toSeconds(song[1]);
            int neededDuration = TARGET_DURATION - currentDuration;

            if (durationToSongsMap.containsKey(neededDuration)) {
                for (String matchedSong : durationToSongsMap.get(neededDuration)) {
                    if (!matchedSong.equals(song[0]) || durationToSongsMap.get(neededDuration).size() > 1) {
                        List<String> result = new ArrayList<>();
                        result.add(song[0]);
                        result.add(matchedSong);
                        return result; // Return the first found pair
                    }
                }
            }
        }

        return new ArrayList<>(); // Return an empty list if no pair is found
    }

    public static void main(String[] args) {
        List<String[]> songTimes1 = List.of(
                new String[]{"Stairway to Heaven", "8:05"}, new String[]{"Immigrant Song", "2:27"},
                new String[]{"Rock and Roll", "3:41"}, new String[]{"Communication Breakdown", "2:29"},
                new String[]{"Good Times Bad Times", "2:48"}, new String[]{"Hot Dog", "3:19"},
                new String[]{"The Crunge", "3:18"}, new String[]{"Achilles Last Stand", "10:26"},
                new String[]{"Black Dog", "4:55"}
        );

        System.out.println(findPair(songTimes1));
    }
}

/**
 * Things to learn from this problem is : Convert Sting to int - > Integer.parseInt(song[0])
 *
 * toDuration : Split the duration of string to 2 parts : 1 part *60 seconds + second part
 * 1. Map   -> duration(use above method to get duration of the song) -> each song
 * 2. Iterate the songs array -> minus target song duration - song duration and check map has that remaining song durations
 *1.
 *2.
 */