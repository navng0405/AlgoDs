package Array;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] givenArray = {1,2,3,4};
        getProductSelf(givenArray);
    }

    private static void getProductSelf(int[] givenArray) {
        int[] leftProduct = new int[givenArray.length];
        int[] rightProduct = new int[givenArray.length];
        int[] result = new int[givenArray.length];
        leftProduct[0] = 1;
        for(int i=1;i<givenArray.length;i++){
            leftProduct[i] = givenArray[i-1]*leftProduct[i-1];
        }

        rightProduct[givenArray.length-1]=1;
        for(int i=givenArray.length-2;i>=0;i--){
            rightProduct[i]=givenArray[i+1]*rightProduct[i+1];
        }

        for(int i=0;i<givenArray.length;i++){
            result[i] = leftProduct[i]*rightProduct[i];
        }

        for(int i=0;i<givenArray.length;i++){
            System.out.print(result[i]);
        }
    }
}
