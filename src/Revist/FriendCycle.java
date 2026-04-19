package Revist;

import java.util.*;

/**
 * Pt 1.Given employees and friendships, find all adjacencies that denote the friendship,
 * A friendship is bi-directional/mutual so if 1 is friends with 2, 2 is also friends with 1.
 *
 * 复制代码Sample Output:
 * Output:
 * 1: 2, 3
 * 2: 1
 * 3: 1, 4
 * 4: 3
 *
 * Pt 2.Now for each department count the number of employees that have a friend in another department
 *
 * 复制代码Sample Output:
 * Output:
 * "Engineer: 2 of 3"
 * "HR: 1 of 1"
 * "Business: 1 of 1"
 *
 * 作者：Esc1pe
 * 链接：https://juejin.cn/post/6844904085913600008
 * 来源：稀土掘金
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
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
        Map<String,Integer> department = buildDeptMap(employees,adjacencies);
        for(Map.Entry<Integer,List<Integer>> entry : adjacencies.entrySet()){
            System.out.println(entry.getKey() + ":" + (entry.getValue().size() == 0 ? "NONE" : entry.getValue()));
        }

        checkIfAllEmployessCycle(adjacencies);

}

    private static void checkIfAllEmployessCycle(Map<Integer, List<Integer>> adjacencies) {
        Set<Integer> visited = new HashSet<>();

    }

    private static Map<String, Integer> buildDeptMap(String[] employees, Map<Integer, List<Integer>> adjacencies) {
        Map<Integer,String> deptMap = new HashMap<>();
        Map<String,Integer> deptCount = new HashMap<>();
        Map<String,Integer> externalFriend = new HashMap<>();
        for(String employee : employees){
            String[] employeeSplit = employee.split(", ");
            int empId = Integer.parseInt(employeeSplit[0]);
            String dept = employeeSplit[2];
            deptMap.put(empId,dept);
            deptCount.put(dept,deptCount.getOrDefault(dept,0)+1);
        }
        for(Integer employeID : adjacencies.keySet()){
            for(Integer frnd : adjacencies.get(employeID)){
                int frnd2 = frnd;
                if(!deptMap.get(employeID).equals(deptMap.get(frnd2))){
                    externalFriend.put(deptMap.get(employeID),externalFriend.getOrDefault(deptMap.get(employeID),0)+1);
                    break;
                }
            }

        }
        for(String dept : deptCount.keySet()){
            externalFriend.putIfAbsent(dept,0);
        }
        return externalFriend;

    }

    private static Map<Integer, List<Integer>> buildFriendshipCycle(String[] employees, String[] friendships) {
        Map<Integer,List<Integer>> adjacencie = new HashMap<>();
        for(String employee : employees){
            String[] emplSplit = employee.split(", ");
            int empId = Integer.parseInt(emplSplit[0]);
            adjacencie.put(empId,new ArrayList<>());
        }

        for(String friendShip:friendships){
            String[] friend = friendShip.split(", ");
            int frnd1 = Integer.parseInt(friend[0]);
            int frnd2 = Integer.parseInt(friend[1]);

            adjacencie.get(frnd1).add(frnd2);
            adjacencie.get(frnd2).add(frnd1);
        }
        return adjacencie;
    }
    }
