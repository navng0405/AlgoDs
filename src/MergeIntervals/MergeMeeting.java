package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Merge Intervals
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example: Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 */
public class MergeMeeting {
    public static void main(String[] args) {
        int[][] meetings = {{2, 6},{1, 3},{8, 10},{9,10},{15,18}};

        Arrays.sort(meetings, Comparator.comparingInt(a-> a[0]));

        List<int[]> mergedMeetings = new ArrayList<>();
        for(int[] meeting: meetings){
            if(mergedMeetings.isEmpty() || mergedMeetings.get(mergedMeetings.size()-1)[1]<meeting[0]){
                mergedMeetings.add(meeting);
            }else{
                mergedMeetings.get(mergedMeetings.size()-1)[1] = Math.max(mergedMeetings.get(mergedMeetings.size()-1)[1],meeting[1]);
            }
        }

        mergedMeetings.toArray(new int[mergedMeetings.size()][]);
        System.out.println(mergedMeetings);

        //MergeInterval
        int[] newInterval = {11,13};

        List<int[]> mergeNewInterval = new ArrayList<>();
        for(int[] meeting : mergedMeetings){
            if(Math.max(meeting[0],newInterval[0])<Math.min(meeting[1],newInterval[1])){
                meeting[0] = Math.min(meeting[0],newInterval[0]);
                meeting[1] = Math.max(meeting[1],newInterval[1]);
                mergeNewInterval.add(meeting);
            }else{
                mergeNewInterval.add(meeting);
            }

        }

        mergeNewInterval.toArray(new int[mergeNewInterval.size()][]);
        System.out.println(mergeNewInterval.stream().toString());


    }
}
