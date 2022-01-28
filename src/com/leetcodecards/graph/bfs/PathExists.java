package com.leetcodecards.graph.bfs;

import java.util.*;

public class PathExists {

    boolean[] seen;
    HashMap<Integer, HashSet<Integer>> adjacencyList;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination)
            return true;

        adjacencyList = new HashMap<>();
        seen = new boolean[n];

        for(int[] edge : edges) {
            if(!adjacencyList.containsKey(edge[0]))
                adjacencyList.put(edge[0], new HashSet<>());
            adjacencyList.get(edge[0]).add(edge[1]);
            if(!adjacencyList.containsKey(edge[1]))
                adjacencyList.put(edge[1], new HashSet<>());
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(source);

        while(!queue.isEmpty()) {
            int curr = queue.pollFirst();
            for(int neighbours : adjacencyList.get(curr)) {
                if (neighbours == destination)
                    return true;
                if(!seen[neighbours]) {
                    seen[neighbours] = true;
                    queue.addLast(neighbours);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        PathExists abc = new PathExists();
        System.out.println();
    }
}
