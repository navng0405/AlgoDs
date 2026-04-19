package Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxMeetings {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        List<Integer> maxMeetings = maxMeetings(start, end);
        System.out.println("Meetings: " + maxMeetings);
    }

    private static List<Integer> maxMeetings(int[] start, int[] end) {
        List<Meeting> meetings = new ArrayList<>();
        for(int i=0;i<start.length;i++){
            meetings.add(new Meeting(start[i],end[i],i+1));
        }
        meetings.sort(Comparator.comparingInt(a -> a.end));
        List<Integer> selectedMeetings = new ArrayList<>();
        int lastMeetingEndTime = 0;
        for(Meeting meeting : meetings){
            if(meeting.start>lastMeetingEndTime){
                selectedMeetings.add(meeting.index);
                lastMeetingEndTime = meeting.end;
            }
        }
        return selectedMeetings;
    }

    static class Meeting{
        int start;
        int end;
        int index;
        Meeting(int start,int end,int index){
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}
