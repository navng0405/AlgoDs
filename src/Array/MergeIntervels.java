package Array;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervels {
    public static void main(String[] args) {
        int[][] givenIntervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println("Merged Intervals : "+ Arrays.toString(mergeIntervals(givenIntervals)));
    }

    private static int[][] mergeIntervals(int[][] givenIntervals) {
        Arrays.sort(givenIntervals,(a,b) -> Integer.compare(a[0],b[0]));
        LinkedList<int[]> merge = new LinkedList<>();
        for(int[] intervals : givenIntervals){
            if(merge.isEmpty() || merge.getLast()[1]<intervals[0]){
                merge.add(intervals);
            }else{
                merge.getLast()[1] = Math.max(merge.getLast()[1],intervals[1]);
            }
        }
        System.out.println(Arrays.asList(merge));
        return merge.toArray(new int[merge.size()][]);
    }
}
