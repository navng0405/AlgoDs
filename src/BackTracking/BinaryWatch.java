package BackTracking;

import java.util.*;

public class BinaryWatch {
    public static void main(String[] args) {
        String[] watchDigits = {"1","2","4","8","16","32","1","2","4","8"};
        readBinaryWatch(watchDigits,1);
    }

    private static List<String> readBinaryWatch(String[] watchDigits, int turnedOn) {
        List<String> result = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                // Combine the hour and minute information into one integer and count the bits
                if (Integer.bitCount(h * 64 + m) == turnedOn) { // 64 = 2^6, shifting minute bits to ensure no overlap with hour bits
                    // Format the time and add to the list
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return result;
    }


}
