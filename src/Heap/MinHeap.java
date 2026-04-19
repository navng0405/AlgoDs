package Heap;

import java.util.ArrayList;

public class MinHeap {
    public ArrayList<Integer> heap;
    MinHeap(){
        heap = new ArrayList<>();
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,temp);
    }

    private int getParentIndex(int i){
        return (i-1)/2;
    }

    private int getLeftChildIndex(int i){
        return 2*i+1;
    }

    private int getRightChildIndex(int i){
        return 2*i+2;
    }



    private void heapifyUp(int i) {
        while (i>0){
            int parentIndex=(i-1)/2;
            if(heap.get(i)<heap.get(parentIndex)){
                swap(i,parentIndex);
                i=parentIndex;
            }else{
                break;
            }
        }
    }

    public void insert(int value){
        heap.add(value);
        heapifyUp(heap.size()-1);
    }

    public int extractMinElement() throws Exception {
        if(heap.isEmpty()){
            System.out.println("Heap is empty");
            throw new Exception("Heap is Empty");
        }

        int minElement = heap.getFirst();
        int lastElement = heap.getLast();
        while (!heap.isEmpty()){
            heap.add(0,lastElement);
            heapifyDown(0);
        }
        return minElement;
    }

    private void heapifyDown(int i) {
        int smallChildIndex = -1;
        while (i<heap.size()){
            if(getLeftChildIndex(i)<heap.size()){
                smallChildIndex=getLeftChildIndex(i);
            }
            if(getRightChildIndex(i)<heap.size() && heap.get(getRightChildIndex(i))<heap.get(getLeftChildIndex(i))){
                smallChildIndex=getRightChildIndex(i);
            }

            if(smallChildIndex ==-1 || heap.get(i)<heap.get(smallChildIndex)){
                break;
            }
            swap(i,smallChildIndex);

        }
    }


    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(4);
        minHeap.insert(6);


        for(int i : minHeap.heap){
            System.out.print(i + " ");
        }
        minHeap.insert(0);
        for(int i : minHeap.heap){
            System.out.print(i + " ");
        }
    }
}
