package Mart;

import java.util.ArrayList;
import java.util.List;

public class LineWrapper {
    public static List<String> wrapLines(String[] words, int maxLength) {
        List<String> lines = new ArrayList<>();
        StringBuilder currentLine = new StringBuilder();

        for (String word : words) {
            // Check if adding the next word exceeds maxLength (considering the hyphen if currentLine is not empty)
            if (currentLine.length() + (currentLine.length() > 0 ? 1 : 0) + word.length() > maxLength) {
                // Add currentLine to lines and reset it
                lines.add(currentLine.toString());
                currentLine = new StringBuilder(word); // Start new line with current word
            } else {
                // Append hyphen before the word if it's not the first word in the line
                if (currentLine.length() > 0) {
                    currentLine.append("-");
                }
                currentLine.append(word);
            }
        }
        // Don't forget to add the last line if it's not empty
        if (currentLine.length() > 0) {
            lines.add(currentLine.toString());
        }

        return lines;
    }

    public static void main(String[] args) {
        String[] words = {"1p3acres", "is", "a", "good", "place", "to", "communicate"};
        int maxLength = 12;
        List<String> wrappedLines = wrapLines(words, maxLength);
        System.out.println(wrappedLines);
    }
}

