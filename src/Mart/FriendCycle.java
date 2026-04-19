package Mart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendCycle {

    public static void main(String[] args) {
        String[] employees = {
                "1, Bill, Engineer",
                "2, Joe, HR",
                "3, Sally, Engineer",
                "4, Richard, Business",
                "6, Tom, Engineer"
        };
        String[] friendships = {
                "1, 2",
                "1, 3",
                "3, 4"
        };
        Map<Integer, List<Integer>> adjacencies  = buildFriendshipCycle(employees,friendships);
        Map<Integer,String> employeeToDepartment = mapEmployeesToDepartments(employees);
        Map<String,Integer> departmentCounts = countEmployeesInDepartments(employees,friendships);
        Map<String, Integer> result = countExternalFriendships(adjacencies, employeeToDepartment, departmentCounts);





        for (Map.Entry<Integer,List<Integer>> entry : adjacencies.entrySet()){
            System.out.print(entry.getKey() + " : ");
            if(entry.getValue().size() == 0){
                System.out.println("None");
            }else{
                System.out.println(entry.getValue());
            }
        }
        System.out.println();
        for(Map.Entry<String,Integer> entry : result.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue() + " of " + departmentCounts.get(entry.getKey()));
        }
    }

    private static Map<String, Integer> countExternalFriendships(Map<Integer, List<Integer>> adjacencies, Map<Integer, String> employeeToDepartment, Map<String, Integer> departmentCounts) {
        Map<String, Integer> externalFriendships = new HashMap<>();
        for(Map.Entry<Integer,List<Integer>> entry : adjacencies.entrySet()){
            int emptID = entry.getKey();
            String dept = employeeToDepartment.get(emptID);
            for(int friend : entry.getValue()){
                String friendDept = employeeToDepartment.get(friend);
                if(!friendDept.equals(dept)){
                    externalFriendships.put(dept,externalFriendships.getOrDefault(dept,0)+1);
                    break;
                }
            }
        }
        // Initialize counts for departments with no external friendships
        for (String dept : departmentCounts.keySet()) {
            externalFriendships.putIfAbsent(dept, 0);
        }

        return externalFriendships;
    }

    private static Map<String, Integer> countEmployeesInDepartments(String[] employees, String[] friendships) {
        Map<String,Integer> result = new HashMap<>();
        for(String employee : employees){
            result.put(employee.split(", ")[2],result.getOrDefault(employee.split(", ")[2],0)+1);
        }
        return result;
    }

    //1, Bill, Engineer

    private static Map<Integer, String> mapEmployeesToDepartments(String[] employees) {
        Map<Integer, String> employeesToDept = new HashMap<>();
        for(String employee : employees){
            int id = Integer.parseInt(employee.split(", ")[0]);
            String dept = employee.split(", ")[2];
            employeesToDept.put(id,dept);
        }

        return employeesToDept;
    }


    private static Map<Integer, List<Integer>> buildFriendshipCycle(String[] employees, String[] friendships) {
        Map<Integer,List<Integer>> adjacencies = new HashMap<>();
        for(String employee : employees){
            int id = Integer.parseInt(employee.split(", ")[0]);
            adjacencies.put(id,new ArrayList<>());
        }

        for(String friendShip : friendships){
            int id1 = Integer.parseInt(friendShip.split(", ")[0]);
            int id2 = Integer.parseInt(friendShip.split(", ")[1]);

            adjacencies.get(id1).add(id2);
            adjacencies.get(id2).add(id1);
        }
        return adjacencies;
    }


}
