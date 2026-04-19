package Mart;

public class OptimizedSort {
    public static void main(String[] args) {
        int[] a1 = {3,2,5};
        int[] a2 = {4,1};

        int[] merged = new int[a1.length + a2.length];
        int index = 0;
        for(int value : a1){
            merged[index++] = value;
        }

        for(int value : a2){
            merged[index++] = value;
        }

        sort(merged,0,merged.length-1);
        for(int i : merged){
            System.out.print(i + " " );
        }

        for(int i=0;i<a1.length;i++){
            a1[i] = merged[i];
        }

        for(int i=0;i<a2.length;i++){
            a2[i] = merged[a1.length+i];
        }
        for(int i : a1){
            System.out.print(i + " " );
        }
        System.out.println();
        for(int i : a2){
            System.out.print(i + " " );
        }
    }

    private static void sort(int[] merged, int left, int right) {
        if(left<right){
            int mid = left +(right-left)/2;
            sort(merged,left,mid);
            sort(merged,mid+1,right);
            merge(merged,left,mid,right);
        }


    }

    private static void merge(int[] merged, int left, int mid, int right) {
        int n1 = mid-left+1;
        int n2 = right-mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for(int i=0;i<n1;i++){
            leftArray[i] = merged[left+i];
        }
        for(int j=0;j<n2;j++){
            rightArray[j] = merged[mid+1+j];
        }

        int i=0,j=0,k=left;

        while(i<n1 && j<n2){
            if(leftArray[i]<=rightArray[j]){
                merged[k] = leftArray[i];
                i++;
            }else{
                merged[k]=rightArray[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            merged[k]=leftArray[i];
            i++;
            k++;
        }
        while(j<n2){
            merged[k]=rightArray[j];
            j++;
            k++;
        }
    }
}
