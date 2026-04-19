package Revist;

import java.util.*;

/**
 * Suppose we have some input data describing a graph of relationships between parents and children over multiple generations.
 * The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.
 * For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:
 *
 * 复制代码parentChildPairs = [  (1, 3), (2, 3), (3, 6), (5, 6),
 *                    (5, 7), (4, 5), (4, 8), (8, 10)  ]
 * Write a function that takes this data as input and returns two collections: one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.
 * 复制代码findNodesWithZeroAndOneParents(parentChildPairs) =>
 *                                   [ [1, 2, 4],    // Individuals with zero parents
 *                                   [5, 7, 8, 10] // Individuals with exactly one parent ]
 *
 *Pt.2 Write a function that takes the graph, as well as two of the individuals in our dataset, as its inputs and returns true if and only if they share at least one ancestor.
 * Sample input and output: （input as same as last part）
 *
 * 复制代码hasCommonAncestor(parentChildPairs, 3, 8) => false
 * hasCommonAncestor(parentChildPairs, 5, 8) => true
 * hasCommonAncestor(parentChildPairs, 6, 8) => true
 * hasCommonAncestor(parentChildPairs, 1, 3) => false
 *
 */
public class CommonAncestor {
    public static void main(String[] args) {
        int[][] parentChildPairs = {
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {8, 10}, {11, 2}
        };
        List<List<Integer>> zeroAndOneParents = findNodesWithZeroAndOneParents(parentChildPairs);
        System.out.println(zeroAndOneParents);
        boolean hasCommonParent = hasCommonAncestor(parentChildPairs,6,10);
        System.out.println(hasCommonParent);
    }

    private static boolean hasCommonAncestor(int[][] parentChildPairs, int individual1, int individual2) {
        Map<Integer,List<Integer>> ancestor = new HashMap<>();
        for(int[] pairs : parentChildPairs){
            int child = pairs[1];
            int parent = pairs[0];
            ancestor.computeIfAbsent(child,k->new ArrayList<>()).add(parent);
        }
        boolean hasCommonParent = false;
        Set<Integer> ancestor1 = findAllAncestor(ancestor,individual1);
        Set<Integer> ancestor2 = findAllAncestor(ancestor,individual2);

        for(Integer parent : ancestor1){
            if(ancestor2.contains(parent)){
                return true;
            }
        }
        return hasCommonParent;
    }

    private static Set<Integer> findAllAncestor(Map<Integer, List<Integer>> ancestor, int individual1) {
        Set<Integer> ancestorList = new HashSet<>();
        dfsgetParent(ancestor,ancestorList,individual1);
        return ancestorList;
    }

    private static void dfsgetParent(Map<Integer, List<Integer>> ancestor, Set<Integer> ancestorList, int individual1) {
        if(ancestor.get(individual1) == null){
            return;
        }

        for(Integer parent : ancestor.get(individual1)){
            if(ancestorList.add(parent)){
                dfsgetParent(ancestor,ancestorList,parent);
            }
        }

    }

    private static List<List<Integer>> findNodesWithZeroAndOneParents(int[][] parentChildPairs) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> zeroList = new ArrayList<>();
        List<Integer> oneList = new ArrayList<>();

        Map<Integer,List<Integer>> ancestor = new HashMap<>();
        Set<Integer> individuals = new HashSet<>();
        for(int[] pairs : parentChildPairs){
            int child = pairs[1];
            int parent = pairs[0];
            ancestor.computeIfAbsent(child,k->new ArrayList<>()).add(parent);
            individuals.add(child);
            individuals.add(parent);
        }
        for(int child:individuals){
            List<Integer> parents = ancestor.get(child);
            if(parents == null){
                zeroList.add(child);
            }else if(parents.size() == 1){
                oneList.add(child);
            }
        }

        result.add(zeroList);
        result.add(oneList);

        return result;

    }
}
