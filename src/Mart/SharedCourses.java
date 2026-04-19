package Mart;

import java.util.*;

public class SharedCourses {
    public static void main(String[] args) {
        String[][] studentCoursePairs = {
                {"58", "Software Design"},
                {"58", "Linear Algebra"},
                {"94", "Art History"},
                {"94", "Operating Systems"},
                {"17", "Software Design"},
                {"58", "Mechanics"},
                {"58", "Economics"},
                {"17", "Linear Algebra"},
                {"17", "Political Science"},
                {"94", "Economics"},
                {"25", "Economics"},
        };

        Map<List<Integer>, List<String>> pairs = findPairs(studentCoursePairs);
        for (Map.Entry<List<Integer>, List<String>> entry : pairs.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static Map<List<Integer>, List<String>> findPairs(String[][] studentCoursePairs) {

        //Result
        Map<List<Integer>, List<String>> sharedCourses = new HashMap<>();

        //Step 1 : Build student course map Map<Stuendid,set of course>
        Map<Integer, Set<String>> studentCourseMap = new HashMap<>();
        for(String[] studentCoursePair : studentCoursePairs){
            int studentId = Integer.parseInt(studentCoursePair[0]);
            String course = studentCoursePair[1];
            Set<String> courses = studentCourseMap.get(studentId);
            if(courses == null) {
                courses = new HashSet<>();
            }
            courses.add(course);
            studentCourseMap.put(studentId,courses);
        }


        //List of studentlist
        List<Integer> studentList = new ArrayList<>(studentCourseMap.keySet());

        //Iterate the studentList and compare first and second student record
        for(int i=0;i<studentList.size();i++){
            for(int j=i+1;j<studentList.size();j++){
                int studentId1 = studentList.get(i);
                int studentId2 = studentList.get(j);

                Set<String> student1Course = studentCourseMap.get(studentId1);
                Set<String> student2Course = studentCourseMap.get(studentId2);

                Set<String> intersection = new HashSet<>(student1Course);
                intersection.retainAll(student2Course);

                sharedCourses.put(Arrays.asList(studentId1,studentId2) , new ArrayList<>(intersection));
            }
        }

        return sharedCourses;
    }
}
