package Mart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EarliestAncestor {
    public static void main(String[] args) {
        int[][] parentChildPairs = {
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {8, 10}, {11, 2}
        };

        System.out.println(findEarliestAncestor(parentChildPairs, 8)); // 4
        System.out.println(findEarliestAncestor(parentChildPairs, 7)); // 4
        System.out.println(findEarliestAncestor(parentChildPairs, 6)); // 11
        System.out.println(findEarliestAncestor(parentChildPairs, 1)); // -1
    }

    private static int findEarliestAncestor(int[][] parentChildPairs, int individual) {
        Map<Integer, List<Integer>> graph = buildGraph(parentChildPairs);

        //earliest ancestor
        int[] earliestAncestor = new int[]{-1,-1}; // ancestor,depth
        dfsFindEasrlistAncestor(graph,earliestAncestor,0 , individual);

        return earliestAncestor[1] > 0 ? earliestAncestor[0] : -1;
    }

    private static void dfsFindEasrlistAncestor(Map<Integer, List<Integer>> graph, int[] earliestAncestor, int depth, int current) {
        //Base Case
        if(!graph.containsKey(current)){
            if(earliestAncestor[1] < depth){
                earliestAncestor[0] = current;
                earliestAncestor[1] = depth;
            }

            return;
        }

        for(int parent : graph.get(current)){
            dfsFindEasrlistAncestor(graph,earliestAncestor,depth+1,parent);
        }
    }

    private static Map<Integer, List<Integer>> buildGraph(int[][] parentChildPairs) {

        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int[] parentChildPair : parentChildPairs){
            graph.computeIfAbsent(parentChildPair[1],k->new ArrayList<>()).add(parentChildPair[0]);
        }

        return graph;
    }
}
