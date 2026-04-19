package Array;

import java.util.Scanner;
class Reorder {
    //Function for reoreder elements based on index array
    public static void reorder(int array[], int index[], int N)
    {
        for(int i=0; i<N; i++)
        {
            while (index[i] != i)
            {
                //storing correct position values
                int  oldIndexValue = index[index[i]];
                int oldElementValue   = array[index[i]];
                array[index[i]] = array[i];
                index[index[i]] = index[i];
                index[i] = oldIndexValue;
                array[i]   = oldElementValue;
            }
        }
    }
    //function to print the given array
    public static void PrintArray(int array[],int N)
    {
        for (int i=0; i<N; i++)
        {
            System.out.print(array[i]+" ");
        }
    }
    public static void main(String[] args)
    {
        Scanner sr = new Scanner(System.in);
        int n = sr.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i] = sr.nextInt();
        }
        int index[] = new int[n];
        for(int i=0;i<n;i++)
        {
            index[i] = sr.nextInt();
        }
        System.out.println("Input array:");
        PrintArray(a,n);
        System.out.println("\nInput index array: ");
        PrintArray(index,n);
        //Reordering by using function
        reorder(a,index,n);
        System.out.println("\nOutput array: ");
        PrintArray(a,n);
        System.out.println("\nOutput index array: ");
        PrintArray(index,n);
    }
}
