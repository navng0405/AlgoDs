package Graph;

import java.util.*;

public class ConnectedComponents {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(3,4);
        graph.addEdge(5,6);
        graph.addEdge(6,7);
        graph.addEdge(8,8);

        findConnectedComponents(graph.adjMap);

    }

    private static void findConnectedComponents(Map<Integer, List<Integer>> adjList) {
        Set<Integer> visited = new HashSet<>();
        //List<Integer> path = new ArrayList<>();
        int componentsCount = 0;
        for(int vertex : adjList.keySet()){
            if(!visited.contains(vertex)){
                System.out.println("Componets " + (componentsCount+1) + " : ");
                dfsUtil(vertex,visited,adjList);
                System.out.println();
                componentsCount++;
            }
        }
        System.out.println("Total Components : " + componentsCount);
    }

    private static void dfsUtil(int vertex ,Set<Integer> visited, Map<Integer, List<Integer>> adjList) {
        visited.add(vertex);
        System.out.print( vertex + " ");

        for(int neighbor : adjList.getOrDefault(vertex,Collections.emptyList())){
            if(!visited.contains(neighbor)){
                dfsUtil(neighbor,visited,adjList);
            }
        }
    }
}


