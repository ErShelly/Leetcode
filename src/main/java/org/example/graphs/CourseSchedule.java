package org.example.graphs;

import java.util.*;

public class CourseSchedule {
    private static HashMap<Integer, List<Integer>> preMap = new HashMap<>();
    private static HashSet<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        int[][] courseSchedule = {{0, 1}, {1, 2}, {2, 0}};
        int course1 = 3;

        System.out.println("CourseSchedule1:" + canFinish(course1, courseSchedule)); //false
        System.out.println("CourseSchedule1 Using Kahn's:" + canFinishUsingBFS(course1, courseSchedule)); //false

        preMap = new HashMap<>();
        visited = new HashSet<>();
        int[][] courseSchedule2 = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {3, 4}};
        int course2 = 5;
        System.out.println("CourseSchedule2:" + canFinish(course2, courseSchedule2)); //true
        System.out.println("CourseSchedule2 Using Kahn's:" + canFinishUsingBFS(course2, courseSchedule2)); //true
    }

    private static boolean canFinish(int numOfCourses, int[][] preRequisites) {
        for (int i = 0; i < numOfCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] pre : preRequisites) {
            preMap.get(pre[0]).add(pre[1]);
        }

        for (int c = 0; c < numOfCourses; c++) {
            if (!dfs(c)) return false;
        }

        return true;
    }

    //Time and Spaca O(n+p) : n=numOfCourses and p= preRequisites
    private static boolean dfs(int course) {
        if (visited.contains(course)) return false;

        if (preMap.get(course).isEmpty()) return true;

        visited.add(course);
        for (int pre : preMap.get(course)) {
            if (!dfs(pre)) return false;
        }

        visited.remove(course);
        preMap.put(course, new ArrayList<>());
        return true;
    }


//    Kahn’s Algorithm is generally more efficient because:
//
//    No backtracking → Reduces queue operations.
//    No visited set needed → Saves memory.
//    Implicit cycle detection → No extra logic required.
//    Guaranteed topological order → Useful in scheduling tasks.

    // TIme and Space: O(n + m)
    private static boolean canFinishUsingBFS(int numOfCourses, int[][] preRequisites) { //Kahn's Algorithm
        int[] indegree = new int[numOfCourses];

        HashMap<Integer, List<Integer>> preMap = new HashMap<>();
        for(int i=0;i<numOfCourses;i++){
            preMap.put(i, new ArrayList<>());
        }

        for(int[] pre: preRequisites){
            indegree[pre[1]]++;
            preMap.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int c=0;c<numOfCourses;c++){
            if(indegree[c]==0){
                queue.add(c);
            }
        }

        int finish = 0;
        while (!queue.isEmpty()){
            int node = queue.poll();
            finish++;

            for(int nei: preMap.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    queue.add(nei);
                }
            }
        }
        return finish == numOfCourses;

    }
}
