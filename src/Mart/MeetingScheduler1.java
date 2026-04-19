package Mart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingScheduler1 {
    public static void main(String[] args) {
        int[][] meetings = {
                {1300, 1500},
                {930, 1200},
                {830, 845},
                {1600, 1800}
        };

        System.out.println("Total idle time: " + calculateTotalIdleTime(meetings));
}

    private static int calculateTotalIdleTime(int[][] meetings) {
        if (meetings == null || meetings.length == 0) return 0;

        //Sort the meetings by their start time
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        //Merge meetings
        List<int[]> mergedMeetings = new ArrayList<>();
        mergedMeetings.add(meetings[0]);
        for(int i=1;i<meetings.length;i++){
            int[] lastMeeting = mergedMeetings.get(mergedMeetings.size()-1);
            if(lastMeeting[1]>=meetings[i][0]){
                lastMeeting[1] = Math.max(lastMeeting[1],meetings[i][1]);
            }else{
                mergedMeetings.add(meetings[i]);
            }
        }

        // Step 3: Calculate idle time
        int totalIdleTime = mergedMeetings.get(0)[0]; // Idle time before the first meeting
        for (int i = 1; i < mergedMeetings.size(); i++) {
            totalIdleTime += mergedMeetings.get(i)[0] - mergedMeetings.get(i - 1)[1];
        }

        return totalIdleTime;

    }
}
