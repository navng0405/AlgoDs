package Array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ShipmentCount {
    public static void main(String[] args) {
        int[] arr = {5,11,10,2,8};
        System.out.println(daysToShipAll(arr));
    }

    public static int daysToShipAll(int[] shipments) {
        Arrays.sort(shipments); // Sort the array
        int totalDays = 0;
        int n = shipments.length;

        for (int i = 0; i < n; i++) {
            // Only consider the warehouses with shipments left
            if (shipments[i] > 0) {
                int diff = (i < n - 1) ? shipments[i + 1] - shipments[i] : shipments[i];
                // Calculate days required for the current segment
                totalDays += (diff > 0) ? 1 : n - i;
                // Update the array to reflect shipments made
                for (int j = i; j < n; j++) {
                    shipments[j] -= diff;
                }
            }
        }

        return totalDays;
    }

    private static int getDays(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            queue.add(arr[i]);
            sum += arr[i];
        }

        int previous = 0;
        int count = 0;
        int warehousecount = arr.length;
        while (!queue.isEmpty()){
            int shipDayCount = queue.poll();
            sum = sum - ((shipDayCount-previous)*warehousecount);
            count = count+1;
            if(sum == 0){
                return count;
            }
            previous = shipDayCount+previous;
            warehousecount--;
        }

        return 0;
    }
}
