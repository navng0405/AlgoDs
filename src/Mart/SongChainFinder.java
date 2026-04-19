package Mart;

import java.util.*;

public class SongChainFinder {

    static class Song {
        String title;
        String firstWord;
        String lastWord;

        Song(String title) {
            this.title = title;
            String[] words = title.split(" ");
            this.firstWord = words[0];
            this.lastWord = words[words.length - 1];
        }
    }

    private static List<Song> findLongestChain(List<Song> songs, Song current, Set<Song> visited) {
        List<Song> maxChain = new ArrayList<>();
        visited.add(current); // Mark the current song as visited

        for (Song next : songs) {
            if (!visited.contains(next) && current.lastWord.equalsIgnoreCase(next.firstWord)) {
                List<Song> chain = findLongestChain(songs, next, visited);
                if (chain.size() > maxChain.size()) {
                    maxChain = chain;
                }
            }
        }

        maxChain.add(0, current); // Add the current song at the beginning of the list
        return maxChain;
    }

    public static List<String> findLongestSongChain(List<String> songTitles, String startTitle) {
        List<Song> songs = new ArrayList<>();
        Song startSong = null;
        for (String title : songTitles) {
            Song song = new Song(title);
            songs.add(song);
            if (title.equals(startTitle)) {
                startSong = song;
            }
        }

        if (startSong == null) return Collections.emptyList(); // Start song not found

        List<Song> longestChain = findLongestChain(songs, startSong, new HashSet<>());
        List<String> longestChainTitles = new ArrayList<>();
        for (Song song : longestChain) {
            longestChainTitles.add(song.title);
        }

        return longestChainTitles;
    }

    public static void main(String[] args) {
        List<String> songTitles = Arrays.asList(
                "Silent Running",
                "Running to Stand Still",
                "Still Loving You",
                "You Shook Me All Night Long",
                "Long Live Rock n' Roll"
        );

        String startTitle = "Silent Running";
        List<String> longestChain = findLongestSongChain(songTitles, startTitle);

        System.out.println("Longest chain starting from \"" + startTitle + "\":");
        for (String title : longestChain) {
            System.out.println(title);
        }
    }
}

