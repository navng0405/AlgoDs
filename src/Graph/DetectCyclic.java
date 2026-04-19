package Graph;

/**
 * Gaol : Determine if aa dirrected graph contains a cycle
 *
 * Model the Problem : Type : Directed
 * Representation : Adjacency List
 *
 * Relevant Properties : Cycle Detection
 * Goal : Detect cycles
 *
 * Alog : DFS with recursion stack
 */

import java.util.LinkedList;
import java.util.List;

public class DetectCyclic {
    public static void main(String args[]){
        Graph graph = new Graph(4);
        graph.addEdgeForList(0,1);
        graph.addEdgeForList(0,2);
        graph.addEdgeForList(1,2);
        graph.addEdgeForList(2,0);
        graph.addEdgeForList(2,3);
        graph.addEdgeForList(3,3);

        if(isCyclic(graph)){

            System.out.println("Given Graph is Cyclic");
        }else{
            System.out.println("Not Cyclic");
        }
    }

    private static boolean isCyclic(Graph graph){
        boolean[] visited = new boolean[graph.vertexCount];
        boolean[] recurStack = new boolean[graph.vertexCount];
        List<Integer> path = new LinkedList<>();
        for(int i=0;i< graph.vertexCount;i++){
            if(isCyclicUtil(i,graph,visited,recurStack,path)){
                System.out.println("Path : " + path);
                return true;
            }
        }
        return false;
    }

    private static boolean isCyclicUtil(int vertex,Graph graph,boolean[] visited,boolean[] recurStack,List<Integer> path){
        if(recurStack[vertex]){
            return true;
        }
        if(visited[vertex]){
            return false;
        }

        recurStack[vertex] = true;
        visited[vertex] = true;
        path.add(vertex);

        for(int neighbor : graph.adjList[vertex]){
            if(isCyclicUtil(neighbor, graph, visited, recurStack,path)){
                return true;
            }
        }

        recurStack[vertex] =false;
        path.removeLast();
        return false;
    }
}
