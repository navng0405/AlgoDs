package Array;

/**
 * 1.Using extra array -> iterate both arrays and if arr[i]<arr[j] -> new[k++] = arr[i++] or new[k++] = arr[j++]
 * then get kth element from final array
 *
 * 2.Without extra array : idea : only increment indexes for 3 pointrr i,j and k-> iterate both arrays and check arr[i]< arr[j] -> check k==i++ then kth element arr[i] else
 */
public class FindKthElement {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};
        int k = 5; // Find the 5th element
        System.out.println("Kth element: " + findKthElementWithExtra(arr1, arr2, k));
        System.out.println("Kth element: " + findKthElement(arr1, arr2, k));
    }

    private static int findKthElementWithExtra(int[] arr1, int[] arr2, int k) {
        int[] sorted = new int[arr1.length+arr2.length];
        int i=0,j=0,d=0;
        while(i<arr1.length && j<arr2.length){
            sorted[d++] = arr1[i]<arr2[j] ? arr1[i++] : arr2[j++];
        }
        while(i<arr1.length){
            sorted[d++]=arr1[i++];
        }
        while(j<arr2.length){
            sorted[d++]=arr2[j++];
        }
        return sorted[k-1];
    }

    private static int findKthElement(int[] arr1, int[] arr2, int kth) {
        int i = 0,j=0,d=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<=arr2[j]){
                d++;
                if(d == kth){
                    return arr1[i];
                }
                i++;
            }else{
                d++;
                if(d == kth){
                    return arr2[j];
                }
                j++;
            }

        }
        while(i<arr1.length){
            d++;
            if(d == kth){
                return arr1[i];
            }
            i++;
        }
        while(j<arr2.length){
            d++;
            if(d == kth){
                return arr2[j];
            }
            j++;
        }

        return -1;

    }
}
