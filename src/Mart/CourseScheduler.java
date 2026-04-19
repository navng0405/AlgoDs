package Mart;

import java.util.*;

public class CourseScheduler {
    public static String findMidCourse(String[][] courses) {
        // Assuming courses is a 2D array where each pair is [prerequisite, course]
        if (courses.length == 0) return "";

        // Step 1: Build the graph and find the start course
        Map<String, String> nextCourseMap = new HashMap<>();
        Set<String> allCourses = new HashSet<>();
        for (String[] pair : courses) {
            nextCourseMap.put(pair[0], pair[1]);
            allCourses.add(pair[0]);
            allCourses.add(pair[1]);
        }

        String start = "";
        for (String course : allCourses) {
            if (!nextCourseMap.containsKey(course)) {
                start = course; // Find the start course (no prerequisite)
                break;
            }
        }

        // Step 2: Traverse the course sequence to find the mid-course
        List<String> sequence = new ArrayList<>();
        String current = start;
        while (current != null) {
            sequence.add(current);
            current = nextCourseMap.get(current);
        }

        // Assuming there is only one order and thus the list size is odd
        return sequence.get(sequence.size() / 2);
    }

    public static void main(String[] args) {
        String[][] courses = {
                {"a", "b"},
                {"b", "c"},
                {"c", "d"},
                {"d", "e"}
        };
        System.out.println("The mid-course is: " + findMidCourse(courses));
    }
}

