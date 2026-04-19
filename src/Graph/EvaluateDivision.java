package Graph;

import java.util.*;
public class EvaluateDivision {
    private static double[] calcEquation(List<List<String>> equations, double[] values,
                                         List<List<String>> queries) {
        // Build the graph
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            // From source to destination the weight of edge is values[i]
            if (graph.containsKey(from)) {
                graph.get(from).put(to, values[i]);
            } else {
                HashMap<String, Double> map = new HashMap<>();
                map.put(to, values[i]);
                graph.put(from, map);
            }
            // From destination to source the weight of edge is (1 / values[i])
            if (graph.containsKey(to)) {
                graph.get(to).put(from, 1 / values[i]);
            } else {
                HashMap<String, Double> map = new HashMap<>();
                map.put(from, 1 / values[i]);
                graph.put(to, map);
            }
        }
        // Solve queries
        double ans[] = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            // Visited set
            HashSet<String> visited = new HashSet<>();
            ans[i] = dfs(graph, queries.get(i).get(0), queries.get(i).get(1), visited);
        }
        return ans;
    }
    private static double dfs(HashMap<String, HashMap<String, Double>> graph, String from, String to,
                              HashSet<String> visited) {
        // Source not found
        if (!graph.containsKey(from)) {
            return -1.0;
        }
        // Direct edge
        if (graph.get(from).containsKey(to)) {
            return graph.get(from).get(to);
        }
        // Mark source as visited
        visited.add(from);
        for (Map.Entry<String, Double> entry : graph.get(from).entrySet()) {
            if (!visited.contains(entry.getKey())) {
                // For all unvisited neighbors of source do dfs
                // neighbor becomes the source and destination remains same
                double ans = dfs(graph, entry.getKey(), to, visited);
                if (ans != -1.0) {
                    // If ans of any neighbor is not -1, return (edge weight * ans of neighbor)
                    return (ans * entry.getValue());
                }
            }
        }
        // All neighbors returned -1, return -1
        return -1.0;
    }
    public static void main(String[] args) {
        // Example
        List<List<String>> equations = new ArrayList<>();
        ArrayList<String> eq1 = new ArrayList<>();
        eq1.add("a");
        eq1.add("b");
        equations.add(eq1);
        ArrayList<String> eq2 = new ArrayList<>();
        eq2.add("b");
        eq2.add("c");
        equations.add(eq2);
        double values[] = new double[2];
        values[0] = 2.0;
        values[1] = 3.0;
        List<List<String>> queries = new ArrayList<>();
        ArrayList<String> q1 = new ArrayList<>();
        q1.add("a");
        q1.add("c");
        queries.add(q1);
        ArrayList<String> q2 = new ArrayList<>();
        q2.add("b");
        q2.add("a");
        queries.add(q2);
        ArrayList<String> q3 = new ArrayList<>();
        q3.add("a");
        q3.add("e");
        queries.add(q3);
        ArrayList<String> q4 = new ArrayList<>();
        q4.add("a");
        q4.add("a");
        queries.add(q4);
        ArrayList<String> q5 = new ArrayList<>();
        q5.add("x");
        q5.add("x");
        queries.add(q5);
        double ans[] = calcEquation(equations, values, queries);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
