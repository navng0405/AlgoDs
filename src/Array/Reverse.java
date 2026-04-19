package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reverse {
    public static List<Integer> reverseArray(List<Integer> a) {
        // Write your code here
        int size = a.size();
        int start = 0;
        int end = size-1;
        while(start<end){
            int tmp = a.get(start);
            a.set(start,a.get(end));
            a.set(end,tmp);
            start++;
            end--;
        }

        return a;
    }

    public static void main(String[] args) {
        List<Integer> givenArray = new ArrayList<>(Arrays.asList(1,4,3,2));
        for (Integer i : reverseArray(givenArray)) {
            System.out.println(i);
        }

    }
}
