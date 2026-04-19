package Grapth;

public class Graph {
    int vertices, edges;    // V-> No. of vertices & E->No of edges
    Edge[] edge;            // /collection of all edges

    class Edge {
        int src, dest;
    }

    // Creates a graph with V vertices and E edges
    Graph(int v, int e) {
        vertices = v;
        edges = e;
        edge = new Edge[edges];
        for (int i = 0; i < e; ++i) {
            edge[i] = new Edge();
        }
    }

    // A utility function to find the subset of an element i
    int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    // A function that does union of two sets of x and y
    void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if(xset != yset){
            parent[xset] = yset;
        }
    }

    // The main function to check whether a given graph contains cycle or not
    boolean isCycle(Graph graph) {
        // Allocate memory for creating V subsets
        int[] parent = new int[graph.vertices];

        // Initialize all subsets as single element sets
        for (int i = 0; i < graph.vertices; ++i)
            parent[i] = -1;

        // Iterate through all edges of graph, find subset of both vertices of every edge, if both subsets are same, then there is cycle in graph.
        for (int i = 0; i < graph.edges; ++i) {
            int x = find(parent, graph.edge[i].src);
            int y = find(parent, graph.edge[i].dest);

            if (x == y)
                return true;

            union(parent, x, y);
        }
        return false;
    }

    public static void main(String[] args) {
        /* Example: Create a graph with 3 vertices and 3 edges to form a cycle */
        int V = 3, E = 3;
        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;

        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;

        if (graph.isCycle(graph))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }
}

