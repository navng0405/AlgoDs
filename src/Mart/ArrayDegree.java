package Mart;

import java.util.*;

/**
 * Given an array of integers, its degree is defined as the number of occurrences of the element that occurs most frequently in the array. Given a list of integers, determine two properties:
 *
 * the degree of the array
 * the length of the shortest sub-array that shares that degree
 *
 *
 * Example
 *
 * arr = [1, 2, 1, 3, 2]
 *
 *
 *
 * The array has a degree of 2 based on the occurrences of values 1 and 2. The subarray of degree 2 based on the 1's is [1, 2, 1] and based on 2's is [2, 1, 3, 2]. Their lengths are 3 and 4, so the shortest is length 3. Return the shortest length.
 */
public class ArrayDegree {
    public static void main(String[] args) {
        List<Integer> givenArr = new ArrayList<>(Arrays.asList(1,2,1,3,2));
        System.out.println("The Length of the shortest sub-array that share degree :" + getShortestLen(givenArr));


    }

    private static Integer getShortestLen(List<Integer> givenArr) {
        if(givenArr.size() == 0){
            return 0;
        }
        int size = givenArr.size();
        int degree = Integer.MIN_VALUE;
        int shortestPath = Integer.MAX_VALUE;
        Map<Integer,int[]> dictionary = new HashMap<>();
        for(int i = 0;i<size;i++){
            if(!dictionary.containsKey(givenArr.get(i))){
                dictionary.put(givenArr.get(i),new int[]{1,i,i});
            }else{
                int[] tmp = dictionary.get(givenArr.get(i));
                tmp[0] = tmp[0]+1;
                tmp[2] = i;
            }
            degree = Math.max(degree,dictionary.get(givenArr.get(i))[0]);
        }
        for (int[] values : dictionary.values()){
            if(degree == values[0]){
                shortestPath = Math.min(shortestPath,values[2]-values[1]+1);
            }
        }
        return shortestPath;
    }
}
