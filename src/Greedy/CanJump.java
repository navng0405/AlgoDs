package Greedy;

public class CanJump {
    public static boolean canJump(int[] nums) {
        int i = 0;
        for (int reach = 0; i < nums.length && i <= reach; ++i){
            System.out.println(reach);
            reach = Math.max(i + nums[i], reach);

        }

        return i == nums.length;
    }

    public static void main(String[] args) {
        int[] givenArray = {2, 3, 1, 1, 4};
        System.out.println(canJump(givenArray));
    }
}
