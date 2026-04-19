package problems.Array;

public class CheckIndex {
    public static void main(String[] args) {
        int[] nums = {0,4,8};
        System.out.println(isSameIndex(nums));
        int[] nums1 = {1,3,7,12};
        System.out.println(isSameIndex(nums1));

    }

    private static int isSameIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i] == i){
                return i;
            }
        }
        return -1;
    }
}
