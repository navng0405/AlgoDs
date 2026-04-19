package Graph;

import java.util.Arrays;

public class GraphColoring {

    // Utility method to check if the current color assignment is safe
    private static boolean isSafe(int v, int graph[][], int color[], int c, int V) {
        for (int i = 0; i < V; i++)
            if (graph[v][i] == 1 && c == color[i])
                return false;
        return true;
    }

    // Recursive utility function to solve m coloring problem
    private static boolean graphColoringUtil(int graph[][], int m, int color[], int v, int vertexCount) {
        // Base case: If all vertices are assigned a color then return true
        if (v == vertexCount)
            return true;

        // Try different colors for vertex v
        for (int c = 1; c <= m; c++) {
            // Check if assignment of color c to v is fine
            if (isSafe(v, graph, color, c, vertexCount)) {
                color[v] = c;

                // Recur to assign colors to rest of the vertices
                if (graphColoringUtil(graph, m, color, v + 1, vertexCount))
                    return true;

                // If assigning color c doesn't lead to a solution, remove it
                color[v] = 0;
            }
        }

        // If no color can be assigned to this vertex, return false
        return false;
    }

    // Method to check if the graph can be colored with at most m colors
    public static boolean graphColoring(int graph[][], int colorCount, int vertexCount) {
        // Initialize all color values as 0
        int colorArr[] = new int[vertexCount];
        Arrays.fill(colorArr, 0);

        // Call graphColoringUtil() for vertex 0
        if (!graphColoringUtil(graph, colorCount, colorArr, 0, vertexCount)) {
            System.out.println("0");
            return false;
        }

        System.out.println("1");
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1},{0,2},{1,2}};
        System.out.println(graphColoring(grid,2,2));
    }
}

