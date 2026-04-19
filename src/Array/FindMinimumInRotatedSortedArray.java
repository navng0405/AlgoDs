package Array;

/**
 * Two pointer technique/binary search
 */
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] givenArray = {4,6,9,2,3};
        findMinimum(givenArray);
    }

    private static void findMinimum(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(arr[mid]>arr[right]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        System.out.println(arr[left]);
    }
}
