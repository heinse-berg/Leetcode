package com.leetcodecards.graph.kahns;

import java.util.*;

public class TreeMHT {

    /*public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        boolean[][] graph = new boolean[n][n];
        boolean[] visited;
        int i, j, minHT = Integer.MAX_VALUE, currDepth;

        for(int[] edge : edges) {
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true;
        }

        for(i = 0; i < n; i++) {
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.addLast(i);
            visited = new boolean[n];
            visited[i] = true;
            currDepth = 0;

            while(!queue.isEmpty()) {
                int currSize = queue.size();
                currDepth++;
                for(int k = 0; k < currSize; k++) {
                    int curr = queue.pollFirst();
                    visited[curr] = true;
                    for (j = 0; j < n; j++) {
                        if (!visited[j] && graph[curr][j]) {
                            queue.addLast(j);
                        }
                    }
                }
            }
            if(minHT > currDepth) {
                minHT = currDepth;
                res.clear();
                res.add(i);
            }
            else if(minHT == currDepth) {
                res.add(i);
            }
        }

        return res;
    }*/

/*    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        LinkedList<Integer> res = new LinkedList<>();
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        boolean[] visited;
        int  minHT = Integer.MAX_VALUE, currDepth;

        if(n == 1) {
            res.add(0);
            return res;
        }

        for(int[] edge : edges) {
            if(!graph.containsKey(edge[0]))
                graph.put(edge[0], new HashSet<>());
            graph.get(edge[0]).add(edge[1]);
            if(!graph.containsKey(edge[1]))
                graph.put(edge[1], new HashSet<>());
            graph.get(edge[1]).add(edge[0]);
        }

        for(int current : graph.keySet()) {
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.addLast(current);
            currDepth = 0;
            visited = new boolean[n];
            while(!queue.isEmpty()) {
                int currSize = queue.size();
                currDepth++;
                for(int k = 0; k < currSize; k++) {
                    int curr = queue.pollFirst();
                    visited[curr] = true;
                    for(int child : graph.get(curr)) {
                        if(!visited[child])
                            queue.addLast(child);
                    }
                }
            }
            if(minHT > currDepth) {
                minHT = currDepth;
                res = new LinkedList<>();
                res.addLast(current);
            }
            else if(minHT == currDepth) {
                res.addLast(current);
            }
        }
        return res;
    }*/

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        int remaining = n, i;
        LinkedList<Integer> queue = new LinkedList<>();

        if(n < 3) {
            ArrayList<Integer> res = new ArrayList<>();
            for(i = 0; i < n; i++)
                res.add(i);
            return res;
        }

        for(i = 0; i < n; i++)
            graph.put(i, new HashSet<>());

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for(Map.Entry<Integer, HashSet<Integer>> entry : graph.entrySet())
            if(entry.getValue().size() == 1)
                queue.add(entry.getKey());

        while(remaining > 2) {
            int currSize  = queue.size();
            for(i = 0; i < currSize; i++) {
                int curr = queue.pollFirst();
                remaining--;
                for(int neighbors : graph.get(curr)) {
                    graph.get(neighbors).remove(curr);
                    if(graph.get(neighbors).size() == 1)
                        queue.add(neighbors);
                }
            }
        }

        return queue;
    }

    public static void main(String[] args) {
        TreeMHT abc = new TreeMHT();
        System.out.println(abc.findMinHeightTrees(4, new int[][] {
                {1,0},{1,2},{1,3}
        }));
        System.out.println(abc.findMinHeightTrees(6, new int[][]
                {{3,0},{3,1},{3,2},{3,4},{5,4}}
        ));
        System.out.println(abc.findMinHeightTrees(2, new int[][]
                {{0,1}}
        ));
    }
    //[[3,0],[3,1],[3,2],[3,4],[5,4]]
}
