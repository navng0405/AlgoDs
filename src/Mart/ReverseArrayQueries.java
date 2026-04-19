package Mart;

public class ReverseArrayQueries {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[][] operations = {{0, 2}, {1, 2}, {0, 2}};

        arr = performOperations(arr, operations);
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    private static int[] performOperations(int[] arr, int[][] operations) {
        for(int[] operation : operations){
            int i = operation[0];
            int j= operation[1];
            while(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return arr;
    }
}
