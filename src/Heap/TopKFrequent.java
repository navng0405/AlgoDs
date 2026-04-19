package Heap;


import java.util.*;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Build a frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        // Step 2: Build a heap using a priority queue
        PriorityQueue<Map.Entry<Integer, Integer>> heap =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        PriorityQueue<Map.Entry<String, Integer>> heap1 = new PriorityQueue<>(
                (a, b) -> a.getValue().equals(b.getValue()) ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );

        // Step 3: Keep k top frequent elements in the heap
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll(); // Remove the least frequent element
            }
        }

        // Step 4: Extract k most frequent elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        TopKFrequent solution = new TopKFrequent();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] topK = solution.topKFrequent(nums, k);
        // Output can be in any order
        for (int num : topK) {
            System.out.print(num + " ");
        }
    }
}

