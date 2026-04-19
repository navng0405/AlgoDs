package Grapth;

import java.util.*;

public class EvalateDivision {
    public static void main(String args[]){
        List<List<String>> equations = new ArrayList<>();
        List<String> eq1 = new ArrayList<>();
        eq1.add("a");
        eq1.add("b");
        List<String> eq2 = new ArrayList<>();
        eq2.add("b");
        eq2.add("c");
        equations.add(eq1);
        equations.add(eq2);

        double[] values = new double[equations.size()];
        values[0]=2.0;
        values[1]=3.0;

        List<List<String>> queries = new ArrayList<>();
        List<String> query = new ArrayList<>();
        query.add("c");
        query.add("a");
        queries.add(query);
        List<String> query1 = new ArrayList<>();
        query1.add("a");
        query1.add("c");
        queries.add(query1);

        double ans[] = calcEquation(equations, values, queries);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }


    }

    private static double[] calcEquation(List<List<String>> equations,double[] values,List<List<String>> queires){
        double[] result = new double[queires.size()];
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);

            //From source to des
            if(graph.containsKey(from)){
                graph.get(from).put(to,values[i]);
            }else{
                HashMap<String,Double> val = new HashMap<>();
                val.put(to,values[i]);
                graph.put(from,val);
            }

            //From des to frpm
            if(graph.containsKey(to)){
                graph.get(to).put(from,1/values[i]);
            }else{
                HashMap<String,Double> val = new HashMap<>();
                val.put(from,1/values[i]);
                graph.put(to,val);
            }
        }

        //Solve queries
        for(int j=0;j<queires.size();j++){
            HashSet<String> visited = new HashSet<>();
            result[j] = dfs(graph,queires.get(j).get(0),queires.get(j).get(1),visited);
        }
        return result;
    }

    private static double dfs(Map<String,Map<String,Double>> graph, String source, String destination, HashSet<String> visited){
        if(!graph.containsKey(source)){
            return -1.0;
        }
        if(graph.get(source).containsKey(destination)){
            return graph.get(source).get((destination));
        }
        visited.add(source);
        for(Map.Entry<String,Double> entry : graph.get(source).entrySet()){
            if(!visited.contains(entry.getKey())){
                double ans = dfs(graph,entry.getKey(),destination,visited);
                if(ans != -1.0){
                    return ans* entry.getValue();
                }
            }
        }
        return -1.0;
    }
}

