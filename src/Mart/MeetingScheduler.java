package Mart;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingScheduler {

    public static void main(String[] args) {
        int[][] meetings = {
                {1300, 1500},
                {930, 1200},
                {830, 845}
        };

        // Test cases
        System.out.println("Can schedule [820, 830]: " + canScheduleMeeting(meetings, 820, 830)); // Expected: true
        System.out.println("Can schedule [1450, 1500]: " + canScheduleMeeting(meetings, 1450, 1500)); // Expected: false
    }

    private static boolean canScheduleMeeting(int[][] meetings, int start, int end) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        for(int[] meeting : meetings){
            if(start<meeting[1] && end>meeting[0]){
                return false;
            }
        }

        return true;


    }

}
