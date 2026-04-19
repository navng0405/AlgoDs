package Mart;

import java.util.*;

public class FriendCycleChecker {
    public static void main(String[] args) {
        String[] employees = {
                "1, Bill, Engineer",
                "2, Joe, HR",
                "3, Sally, Engineer",
                "4, Richard, Business",
                "6, Tom, Engineer"
        };

        String[] friendships2 = {
                "1, 2",
                "1, 3",
                "3, 4",
                "6, 1"
        };

        Map<Integer, List<Integer>> adjacencies = buildFriendshipMap(employees, friendships2);
        System.out.println(isSingleFriendCycle(adjacencies, employees.length));
    }

    private static boolean isSingleFriendCycle(Map<Integer, List<Integer>> adjacencies, int employeeCount) {
        Set<Integer> visited = new HashSet<>();
        Integer start = adjacencies.keySet().iterator().next();// Start from any employee
        dfs(adjacencies,visited,start);

        return visited.size() == employeeCount;
    }

    private static void dfs(Map<Integer, List<Integer>> adjacencies, Set<Integer> visited, Integer node) {
        visited.add(node);
        for(int neightbor : adjacencies.getOrDefault(node,Collections.emptyList())){
            if(!visited.contains(neightbor)){
                dfs(adjacencies,visited,neightbor);
            }
        }
    }

    private static Map<Integer,List<Integer>> buildFriendshipMap(String[] employees, String[] friendships2) {
        Map<Integer, List<Integer>> adjacencies = new HashMap<>();
        for(String employee : employees){
            int id = Integer.parseInt(employee.split(", ")[0]);
            adjacencies.put(id,new ArrayList<>());
        }

        for(String friendShip : friendships2){
            int id1 = Integer.parseInt(friendShip.split(", ")[0]);
            int id2 = Integer.parseInt(friendShip.split(", ")[1]);
            adjacencies.get(id1).add(id2);
            adjacencies.get(id2).add(id1);

        }

        return adjacencies;
    }
}
