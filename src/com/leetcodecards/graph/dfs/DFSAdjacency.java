package com.leetcodecards.graph.dfs;

import java.util.*;

public class DFSAdjacency {

    /*public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        boolean[] seen = new boolean[n];

        for(int i = 0; i < n; i++)
            adjacencyList.add(new ArrayList<>());

        for(int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(source);

        while(!stack.isEmpty()) {
            int node = stack.pop();
            if (node == destination)
                return true;

            if (seen[node])
                continue;
            seen[node] = true;

            for (Integer i : adjacencyList.get(node))
                if (!seen[i])
                    stack.push(i);
        }
        return false;
    }*/

    boolean[] seen;
    ArrayList<ArrayList<Integer>> adjacencyList;

    public boolean dfs(int node, int destination) {
        if(node == destination)
            return true;
        seen[node] = true;
        for(int i : adjacencyList.get(node))
            if(!seen[i])
                return dfs(i, destination);
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        adjacencyList = new ArrayList<>();
        seen = new boolean[n];

        for(int i = 0; i < n; i++)
            adjacencyList.add(new ArrayList<>());

        for(int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        return dfs(source, destination);
    }

    public static void main(String[] args) {
        DFSAdjacency abc = new DFSAdjacency();
        System.out.println(abc.validPath(6, new int[][]
                        {{4,0}, {0,1}, {0,3}, {1,5}},
                3, 2));
    }
}
