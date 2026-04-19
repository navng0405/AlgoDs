package Graph;

import javax.swing.*;
import java.util.*;

public class ShortestPathInGraph {
    public static void main(String[] args) {
        int n = 9; // Number of nodes
        int m = 8; // Number of edges
        int[][] edges = {
                {0, 1}, {0, 3}, {1, 2}, {3, 4},
                {3, 7}, {4, 5}, {4, 6}, {5, 6},
                {6, 7}, {7, 8}
        };
        int s = 0; // Starting node
        int t = 8; // Target node
        LinkedList<Integer> path = shortestPath(edges, n, m, s, t);
        System.out.println("Shortest path from " + s + " to " + t + " is: " + path);
    }

    private static LinkedList<Integer> shortestPath(int[][] edges, int noOfNodes, int noOfEdges, int start, int target) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<noOfNodes;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        //Array to store the path taken
        int[] previousPath = new int[noOfNodes];
        Arrays.fill(previousPath,-1);

        bfs(graph,start,target,previousPath);

        return reconstruct(start,target,previousPath);

    }

    private static LinkedList<Integer> reconstruct(int start, int target, int[] previousPath) {
        LinkedList<Integer> path = new LinkedList<>();
        for(int at=target;at != -1;at=previousPath[at]){
            path.addFirst(at);
        }
        if(path.getFirst() != start){
            return new LinkedList<>();
        }
        return path;
    }

    private static void bfs(List<List<Integer>> graph, int start, int target, int[] previousPath) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int house = queue.poll();
            if(house == target){
                break;
            }
            for(int neighbor : graph.get(house)){
                if(!visited[neighbor]){
                    queue.add(neighbor);
                    visited[neighbor] = true;
                    previousPath[neighbor] = house;
                }
            }
        }

    }
}
