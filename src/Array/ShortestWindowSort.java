package Array;

public class ShortestWindowSort {
    public static void main(String args[]) {
        System.out.println(findSmallestSubArr(new int[]{1, 2, 5, 3, 7, 10, 9, 12}));
    }

    public static int findSmallestSubArr(int[] givenArray) {
        int lowleft = 0;
        int highRight = givenArray.length - 1;
        while (lowleft <= givenArray.length - 1 && givenArray[lowleft] <= givenArray[lowleft + 1]) {
            lowleft++;
        }
        if (lowleft == givenArray.length - 1) {
            return 0;
        }
        while (highRight > 0 && givenArray[highRight] >= givenArray[highRight - 1]) {
            highRight--;
        }
        int subMax = Integer.MIN_VALUE;
        int subMin = Integer.MAX_VALUE;

        for (int k = lowleft; k <= highRight; k++) {
            subMin = Math.min(subMin, givenArray[k]);
            subMax = Math.max(subMax, givenArray[k]);
        }

        while (givenArray[lowleft - 1] > subMin && lowleft > 0) {
            lowleft--;
        }

        while (givenArray[highRight + 1] < subMax && highRight < givenArray.length - 1) {
            highRight++;
        }
        return highRight - lowleft + 1;


    }
}