package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Activity{
    int startTime;
    int endTime;
    Activity(int startTime,int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
public class ActivitySelection {

    public static void main(String[] args) {
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity(1, 4));
        activities.add(new Activity(3, 5));
        activities.add(new Activity(0, 6));
        activities.add(new Activity(5, 7));
        activities.add(new Activity(3, 8));
        activities.add(new Activity(5, 9));
        activities.add(new Activity(6, 10));
        activities.add(new Activity(8, 11));
        activities.add(new Activity(8, 12));
        activities.add(new Activity(2, 13));
        activities.add(new Activity(12, 14));

        System.out.println("Maximum number of activities: " + maxActivities(activities));
    }

    private static int maxActivities(ArrayList<Activity> activities) {
        Collections.sort(activities, Comparator.comparingInt(a -> a.endTime));
        int count=1;
        int prevEndTime = activities.getFirst().endTime;
        System.out.println(activities.getFirst().startTime + " - " + activities.getFirst().endTime+" , ");
        for(int i=1;i<=activities.size()-1;i++){
            if(activities.get(i).startTime>=prevEndTime){
                System.out.println(activities.get(i).startTime + " - " + activities.get(i).endTime+" , ");
                count++;
                prevEndTime=activities.get(i).endTime;
            }
        }
        return count;
    }
}
