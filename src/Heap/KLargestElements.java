package Heap;

import java.util.PriorityQueue;

public class KLargestElements {

    public static int[] findKLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Build a min heap of the first K elements
        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }

        // For the rest of the elements, if the element is greater than the min
        // element of the heap, replace the min element with the new one
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        // Extract the elements from the min heap and put them into an array in reverse order
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 787, 1, 23};
        int k = 2;

        int[] kLargest = findKLargest(arr, k);

        // Print the K largest elements in decreasing order
        for (int num : kLargest) {
            System.out.print(num + " ");
        }
    }
}

