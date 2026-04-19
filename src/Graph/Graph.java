package Graph;

import java.util.*;

public class Graph {
    Graph(){

    }
    Map<Integer, List<Integer>> adjMap = new HashMap<>();

    public void addEdge(int source,int desc){
        adjMap.putIfAbsent(source,new ArrayList<>());
        adjMap.putIfAbsent(desc,new ArrayList<>());
        adjMap.get(source).add(desc);
        adjMap.get(desc).add(source);
    }

    int vertexCount;
    public LinkedList<Integer> adjList[];

    Graph(int vertexCount){
        this.vertexCount = vertexCount;

        adjList = new LinkedList[vertexCount];
        for(int i=0;i<vertexCount;i++){
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdgeForList(int source,int dest){
        adjList[source].add(dest);
    }





}
