package Array;

public class TrapRainWater {
    public static void main(String[] args) {
        int[] buildlingHeights = {1,0,3,0,2,0,5};
        System.out.println("Total trapped Water units: "+getTrappedWater(buildlingHeights));
    }

    private static int getTrappedWater(int[] buildlingHeights) {
        int noOfBuildings = buildlingHeights.length;
        int[] leftMaxHeights = new int[buildlingHeights.length];
        int[] rightMaxHeights = new int[buildlingHeights.length];
        leftMaxHeights[0] = buildlingHeights[0];
        int totalTrappedWater = 0;
        for(int i=1;i<noOfBuildings;i++){
            leftMaxHeights[i] = Math.max(leftMaxHeights[i-1],buildlingHeights[i]);
        }

        rightMaxHeights[noOfBuildings-1] = buildlingHeights[noOfBuildings-1];
        for (int i=noOfBuildings-2;i>=0;i--){
            rightMaxHeights[i] = Math.max(rightMaxHeights[i+1],buildlingHeights[i]);
        }
        for(int i=0;i<noOfBuildings-1;i++){
            totalTrappedWater = totalTrappedWater+Math.min(leftMaxHeights[i],rightMaxHeights[i])-buildlingHeights[i];
        }
        return totalTrappedWater;
    }
}
