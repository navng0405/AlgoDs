package Mart;

import java.util.*;

public class FamilyTreeAnalysis {
    public static void main(String[] args) {
        int[][] parentChildPairs = {
                {1, 3}, {2, 3}, {3, 6}, {5, 6},
                {5, 7}, {4, 5}, {4, 8}, {8, 10}
        };

        List<List<Integer>> result = findNodesWithZeroAndOneParents(parentChildPairs);
        System.out.println(result);
        System.out.println(hasCommonAncestor(parentChildPairs, 3, 8)); // false
        System.out.println(hasCommonAncestor(parentChildPairs, 5, 8)); // true
        System.out.println(hasCommonAncestor(parentChildPairs, 6, 8)); // true
        System.out.println(hasCommonAncestor(parentChildPairs, 1, 3));
        buildGraph(parentChildPairs);

    }

    private static boolean hasCommonAncestor(int[][] parentChildPairs, int individual1, int individual2) {
        Map<Integer, List<Integer>> graph = buildGraph(parentChildPairs);
        Set<Integer> ancestors1 = findAllAncestors(graph, individual1);
        Set<Integer> ancestors2 = findAllAncestors(graph, individual2);
        for(int ancestor : ancestors1){
            if(ancestors2.contains(ancestor)){
                return true;
            }
        }
        return false;
    }

    private static Map<Integer, List<Integer>> buildGraph(int[][] pairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : pairs) {
            graph.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }
        return graph;
    }

    // Method to find all ancestors of a given individual
    private static Set<Integer> findAllAncestors(Map<Integer, List<Integer>> graph, int individual) {
        Set<Integer> ancestors = new HashSet<>();
        dfs(graph, individual, ancestors);
        return ancestors;
    }

    // Depth-First Search to find ancestors
    private static void dfs(Map<Integer, List<Integer>> graph, int current, Set<Integer> ancestors) {
        if (!graph.containsKey(current)) return; // Base case: no parents
        for (int parent : graph.get(current)) {
            if (ancestors.add(parent)) { // If the parent is added successfully (not already visited)
                dfs(graph, parent, ancestors);
            }
        }
    }


    private static List<List<Integer>> findNodesWithZeroAndOneParents(int[][] parentChildPairs) {

        List<Integer> zeroParents = new ArrayList<>();
        List<Integer> oneParent = new ArrayList<>();

        Set<Integer> individuals = new HashSet<>();
        Map<Integer,Integer> childPairs = new HashMap<>();

        for(int[] parentChildPair : parentChildPairs){
            int parent = parentChildPair[0];
            int child = parentChildPair[1];
            individuals.add(parent);
            individuals.add(child);

            childPairs.put(child,childPairs.getOrDefault(child,0)+1);
        }

        for(int individual : individuals){
            int count = childPairs.getOrDefault(individual,0);
            if(count == 0){
                zeroParents.add(individual);
            }else if(count == 1){
                oneParent.add(individual);
            }
        }
        Collections.sort(zeroParents);
        Collections.sort(oneParent);

        return Arrays.asList(zeroParents,oneParent);
    }
}
