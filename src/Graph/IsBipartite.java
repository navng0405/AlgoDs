package Graph;

import java.util.*;

/**
 * Approach
 * A common approach to solve this problem is using Graph Coloring with a Depth-First Search (DFS) or Breadth-First Search (BFS).
 * The idea is to assign colors to each vertex such that no two adjacent vertices have the same color.
 * If you can successfully color the graph using only two colors, the graph is bipartite.
 *
 * Steps
 * Initialize a Color Array: Create an array to store the color of each vertex, initialized with -1, indicating that no vertex has been colored yet.
 * Choose a Starting Vertex: Start with any vertex as the starting point for the BFS or DFS.
 * Color and Explore:        Assign one color to the starting vertex, then alternately color the neighboring vertices with the other color.
 * Continue this process for all vertices, exploring each vertex's neighbors.
 * Check for Conflicts:      If, at any point, you find an adjacent vertex that has already been colored with the same
 * color as the current vertex, the graph cannot be bipartite.
 * Disconnected Graph:       If the graph is disconnected, you need to ensure that the BFS or DFS runs from every uncolored vertex,
 * as the initial run may not cover all vertices.
 */
public class IsBipartite {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        int vertexCount = 4;
        for(int i=0;i<vertexCount;i++){
            graph.add(i,new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(3).add(2);

        if(isBipartite(graph,vertexCount)){
            System.out.println("Bipar");
        }else{
            System.out.println("NO");
        }
    }

    private static boolean isBipartite(List<List<Integer>> graph,int vertextCount) {
        int[] colorArr = new int[vertextCount];
        Arrays.fill(colorArr, -1);
        for(int i=0;i<vertextCount;i++){
            if(colorArr[i] == -1){
                if(!bfsCheck(graph,i,colorArr)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfsCheck(List<List<Integer>> graph, int src, int[] colorArr) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        colorArr[src]=1;
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            for(int i : graph.get(vertex)){
                if(colorArr[i] == colorArr[vertex]){
                    return false;
                }else if(colorArr[i] == -1){
                    colorArr[i] = 1 - colorArr[vertex];
                    queue.add(i);
                }
            }
        }
        return true;
    }
}
