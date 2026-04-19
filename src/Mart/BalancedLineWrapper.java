package Mart;

import java.util.ArrayList;
import java.util.List;

public class BalancedLineWrapper {
    public static List<String> wrapAndBalanceLines(String[] lines, int maxLength) {
        List<String> wrappedLines = new ArrayList<>();

        for (String line : lines) {
            String[] words = line.split(" ");
            List<String> currentLineWords = new ArrayList<>();
            int currentLineLength = 0;

            for (String word : words) {
                // Check if adding the next word exceeds maxLength
                if (currentLineLength + word.length() + currentLineWords.size() > maxLength) {
                    // Wrap and balance the current line
                    wrappedLines.add(balanceLine(currentLineWords, maxLength));
                    currentLineWords.clear();
                    currentLineLength = 0;
                }
                currentLineWords.add(word);
                currentLineLength += word.length();
            }

            // Wrap and balance the last line
            if (!currentLineWords.isEmpty()) {
                wrappedLines.add(balanceLine(currentLineWords, maxLength));
            }
        }

        return wrappedLines;
    }

    private static String balanceLine(List<String> words, int maxLength) {
        int totalHyphens = maxLength - words.stream().mapToInt(String::length).sum();
        int gaps = words.size() - 1;
        StringBuilder balancedLine = new StringBuilder();

        for (int i = 0; i < words.size(); i++) {
            balancedLine.append(words.get(i));
            int hyphensToAdd = gaps > 0 ? (totalHyphens + gaps - 1) / gaps : totalHyphens;
            char[] hyphens = new char[hyphensToAdd];
            java.util.Arrays.fill(hyphens, '-');
            balancedLine.append(hyphens);
            totalHyphens -= hyphensToAdd;
            gaps--;
        }

        // Trim trailing hyphens if any
        return balancedLine.toString().replaceAll("-+$", "");
    }

    public static void main(String[] args) {
        String[] lines = {"123 45 67 8901234 5678", "12345 8 9 0 1 23"};
        System.out.println(wrapAndBalanceLines(lines, 10));
        System.out.println(wrapAndBalanceLines(lines, 15));
    }
}
