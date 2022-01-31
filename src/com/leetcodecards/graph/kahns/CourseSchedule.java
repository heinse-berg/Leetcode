package com.leetcodecards.graph.kahns;

import java.util.*;

public class CourseSchedule {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int i;
        HashMap<Integer, HashSet<Integer>> prereq = new HashMap<>();
        int[] inDegree = new int[numCourses], topo = new int[numCourses];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int[] pre : prerequisites) {
            if(!prereq.containsKey(pre[1]))
                prereq.put(pre[1], new HashSet<>());
            prereq.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }

        for(i = 0; i <  inDegree.length; i++) {
            if(inDegree[i] == 0) {
                queue.addLast(i);
            }
        }

        i = 0;
        while(!queue.isEmpty()) {
            int curr = queue.pollFirst();
            topo[i++] = curr;
            HashSet<Integer> set = prereq.get(curr);
            if(set != null) {
                for(int child : set) {
                    if(inDegree[child] > 0)
                        inDegree[child]--;
                    if(inDegree[child] == 0) {
                        queue.add(child);
                    }
                }
            }
        }

        return (i == inDegree.length) ? topo : new int[]{};
    }

    public static void main(String[] args) {
        CourseSchedule abc = new CourseSchedule();
        System.out.println(Arrays.toString(abc.findOrder(4, new int[][]{
                {1,0},{2,0},{3,1},{3,2}
        })));
        //[[1,0],[2,0],[3,1],[3,2]]
    }
}
