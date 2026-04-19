package TwoPointer;

public class MergeSortedArray {
    public static void main(String args[])
    {
        int m = 3 , n = 3;
        int[] a = new int[m + n];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        int[] b = {2 , 6 , 7};
        merge(a , m , b , n);
        for(int i = 0 ; i < a.length ; i++)
            System.out.print(a[i] + " ");
    }

    private static void merge(int[] a, int m, int[] b, int n) {
        //3 index
        int i = m-1;
        int j = n-1;
        int index = a.length-1;
        while(i>=0 && j>=0){
            if(a[i] >= b[j]){
                a[index] = a[i];
                i--;
            }else{
                a[index] = b[j];
                j--;
            }
            index--;
        }
        while (i>=0){
            a[index] = a[i];
            index--;
            i--;
        }

        while (j>=0){
            a[index] = a[j];
            index--;
            j--;
        }
    }
}
