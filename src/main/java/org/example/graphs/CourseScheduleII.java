package org.example.graphs;

import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args) {
        int[][] courseSchedule = {{0, 1}, {1, 2}, {2, 0}};
        int course1 = 3;

        System.out.println("CourseSchedule1 Using Kahn's:" + Arrays.toString(findOrder(course1, courseSchedule))); //false

        int[][] courseSchedule2 = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {3, 4}};
        int course2 = 5;
        System.out.println("CourseSchedule2 Using Kahn's:" + Arrays.toString(findOrder(course2, courseSchedule2))); //true
    }

    private static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        HashMap<Integer, List<Integer>> preMap = new HashMap<>();
        for(int i=0; i<numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            indegree[pre[1]]++;
            preMap.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int c=0; c<numCourses; c++){
            if(indegree[c]==0){
                q.add(c);
            }
        }

        int finish=0;
        int[] output = new int[numCourses];

        while(!q.isEmpty()){
            int node = q.poll();
            output[numCourses - finish - 1] = node;
            finish++;

            for(int nei: preMap.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0)
                {
                    q.add(nei);
                }
            }
        }

        return finish == numCourses? output : new int[0];
    }
}
