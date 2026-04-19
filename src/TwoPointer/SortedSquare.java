package TwoPointer;

public class SortedSquare {
    public static void main(String[] args) {
        int[] givenArray = {-4,-1,0,3,10};
        for(int i : result(givenArray)){
            System.out.print(i + " ");
        }
    }

    private static int[] result(int[] givenArray){
        int[] result = new int[givenArray.length];
        int left =0;
        int right = givenArray.length-1;
        int i = givenArray.length-1;
        while(left<=right){
            if(Math.abs(left*left) >= Math.abs(right*right)){
                result[i] = Math.abs(left*left);
                i--;
                left++;
            }else{
                result[i] = Math.abs(right*right);
                i--;
                right--;
            }
        }
        return result;
    }
}
