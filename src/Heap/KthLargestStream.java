package Heap;

import java.util.PriorityQueue;

public class KthLargestStream {
    public static void main(String[] args) {
        KthLargestStream kthLargestStream = new KthLargestStream();
        int[] stream = {3, 4};
        int k = 1;
        int[] kthLargestElements = kthLargestStream.findKthLargest(stream, k);
        for (int elem : kthLargestElements) {
            System.out.print(elem + " ");
        }
    }

    private int[] findKthLargest(int[] stream, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int[] result = new int[stream.length];
        for(int i=0;i<stream.length;i++){
            heap.add(stream[i]);
            if(heap.size()>k){
                heap.poll();
            }

            if(heap.size()<k){
                result[i]=-1;
            }else{
                result[i]=heap.peek();
            }
        }
        return result;
    }
}
