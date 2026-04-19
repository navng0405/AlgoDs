package Revist;

public class MergeSortModified {
    public static void main(String[] args) {
        int[] array1 = {3,5,4};
        int[] array2 = {2,1};

        //Merge these 2 arrays into 1 array
        //Sort that array using merge sort
        //split that merged array back to original array

        int[] mergedArray = new int[array1.length+array2.length];
        int index=0;
        for(int value : array1){
            mergedArray[index++] = value;
        }
        for(int value : array2){
            mergedArray[index++] = value;
        }

        sortMergedArray(mergedArray,0,mergedArray.length-1);

        for(int i=0;i<array1.length;i++){
            array1[i] = mergedArray[i];
        }

        for(int j=0;j< array2.length;j++){
            array2[j] = mergedArray[array1.length+j];
        }

        for(int i: array1){
            System.out.print(i);
        }
        System.out.println();
        for(int j:array2){
            System.out.print(j);
        }
    }

    private static void sortMergedArray(int[] mergedArray,int left,int right){
        int mid = left +(right-left)/2;
        if(left<right){
            sortMergedArray(mergedArray,left,mid);
            sortMergedArray(mergedArray,mid+1,right);
            merge(mergedArray,left,mid,right);
        }
    }

    private static void merge(int[] mergedArray,int left,int mid,int right){
        int n1 = mid-left+1;
        int n2 = right-mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for(int i=0;i<n1;i++){
            leftArray[i] = mergedArray[left+i];
        }
        for(int j=0;j<n2;j++){
            rightArray[j] = mergedArray[mid+1+j];
        }

        int i=0,j=0,k=left;
        while(i<n1 && j<n2){
            if(leftArray[i]<=rightArray[j]){
                mergedArray[k]=leftArray[i];
                i++;
            }else{
                mergedArray[k]=rightArray[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            mergedArray[k]=leftArray[i];
            i++;
            k++;
        }
        while(j<n2){
            mergedArray[k]=rightArray[j];
            j++;
            k++;
        }
    }
}
