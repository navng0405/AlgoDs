package Revist;

public class MacProduct {
    public static void main(String[] args) {
        int[] arr=  {2,3,-4,-1};
        getMaxPro(arr);
    }
    private static void getMaxPro(int[] arr){
        if(arr.length == 0){
            System.out.println(0);
        }

        int maxProduct = 1;
        int minProduct = 1;
        int result = maxProduct;
        for(int i=0;i<arr.length;i++){
            int temp = maxProduct;
            maxProduct = Math.max(Math.max(maxProduct*arr[i],minProduct*arr[i]),arr[i]);
            minProduct = Math.min(Math.min(temp*arr[i],minProduct*arr[i]),arr[i]);

            result = Math.max(maxProduct,result);
        }

        System.out.println(result);
    }
}
