package Mart;

import java.util.*;

public class SongPairFinder {

    private static int[] convertToSeconds(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return new int[]{minutes * 60 + seconds, minutes, seconds};
    }

    public static List<String> findPair(String[][] songTimes) {
        Map<Integer, List<String>> songDurations = new HashMap<>();
        for (String[] song : songTimes) {
            int[] duration = convertToSeconds(song[1]);
            songDurations.putIfAbsent(duration[0], new ArrayList<>());
            songDurations.get(duration[0]).add(song[0]);
        }

        for (String[] song : songTimes) {
            int[] duration = convertToSeconds(song[1]);
            int targetDuration = 420 - duration[0]; // 7 minutes in seconds minus current song duration
            if (songDurations.containsKey(targetDuration)) {
                for (String matchingSong : songDurations.get(targetDuration)) {
                    if (!matchingSong.equals(song[0])) {
                        return Arrays.asList(song[0], matchingSong);
                    }
                }
            }
        }
        return new ArrayList<>(); // No pair found
    }

    public static void main(String[] args) {
        String[][] song_times_1 = {
                {"Stairway to Heaven", "8:05"}, {"Immigrant Song", "2:27"},
                {"Rock and Roll", "3:41"}, {"Communication Breakdown", "2:29"},
                {"Good Times Bad Times", "2:48"}, {"Hot Dog", "3:19"},
                {"The Crunge", "3:18"}, {"Achilles Last Stand", "10:26"},
                {"Black Dog", "4:55"}
        };
        List<String> pair = findPair(song_times_1);
        if (!pair.isEmpty()) {
            System.out.println("Pair found: " + pair.get(0) + " and " + pair.get(1));
        } else {
            System.out.println("No pair found.");
        }
    }
}

