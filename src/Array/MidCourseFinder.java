package Array;

import java.util.*;

public class MidCourseFinder {

    public static String findMidCourse(List<List<String>> pairs) {
        // Maps course to its prerequisite
        Map<String, String> prereqMap = new HashMap<>();
        // Tracks the number of times a course appears as a prerequisite
        Map<String, Integer> prereqCount = new HashMap<>();

        for (List<String> pair : pairs) {
            prereqMap.put(pair.get(1), pair.get(0));
            prereqCount.put(pair.get(0), prereqCount.getOrDefault(pair.get(0), 0));
            prereqCount.put(pair.get(1), prereqCount.getOrDefault(pair.get(1), 0) + 1);
        }

        // Find the head of the program (a course with no prerequisites)
        String currentCourse = "";
        for (String course : prereqCount.keySet()) {
            if (prereqCount.get(course) == 0) {
                currentCourse = course;
                break;
            }
        }

        // The number of steps to take (50% of the courses, round down)
        int steps = prereqMap.size() / 2;
        // Traverse the list of courses, reaching the 'mid' course
        for (int i = 0; i < steps; i++) {
            currentCourse = prereqMap.get(currentCourse);
        }

        return currentCourse;
    }

    public static void main(String[] args) {
        List<List<String>> pairs1 = Arrays.asList(
                Arrays.asList("Foundations of Computer Science", "Operating Systems"),
                Arrays.asList("Data Structures", "Algorithms"),
                Arrays.asList("Computer Networks", "Computer Architecture"),
                Arrays.asList("Algorithms", "Foundations of Computer Science"),
                Arrays.asList("Computer Architecture", "Data Structures"),
                Arrays.asList("Software Design", "Computer Networks")
        );

        System.out.println(findMidCourse(pairs1));
    }
}

