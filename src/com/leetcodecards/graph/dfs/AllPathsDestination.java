package com.leetcodecards.graph.dfs;

import java.util.*;

public class AllPathsDestination {

    ArrayList<LinkedList<Integer>> graph;
    boolean[] seen;

    public boolean dfs(int source, int destination) {
        if(source == destination)
            return true;

        if(graph.get(source).isEmpty())
            return false;

        seen[source] = true;

        for(int neigh : graph.get(source)) {
            if(seen[neigh])
                return false;

            if(!dfs(neigh, destination))
                return false;
        }

        seen[source] = false;
        return true;
    }

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        int i;
        seen = new boolean[n];

        for(i = 0; i < n; i++)
            graph.add(new LinkedList<>());

        for(int[] edge : edges)
            graph.get(edge[0]).addLast(edge[1]);

        return graph.get(destination).isEmpty() && dfs(0, n - 1);
    }


    public static void main(String[] args) {
        AllPathsDestination abc = new AllPathsDestination();
        System.out.println(abc.leadsToDestination(4, new int[][]
                {{0,1},{0,2},{1,3},{2,3}}, 0, 3));
        System.out.println(abc.leadsToDestination(4, new int[][]
                {{0,1},{0,3},{1,2},{2,1}}, 0, 3));
        System.out.println(abc.leadsToDestination(3, new int[][]
                {{0,1},{0,2}}, 0, 2));
        System.out.println(abc.leadsToDestination(3, new int[][]
                {{0,1},{1,1},{1,2}}, 0, 2));
        System.out.println(abc.leadsToDestination(4, new int[][]
                {{0,1},{1,2},{2,3},{3,0}}, 0, 3));
        System.out.println(abc.leadsToDestination(4, new int[][]
                {{0,1},{1,2},{0,2},{1,3},{2,3}}, 0, 3));
        System.out.println(abc.leadsToDestination(5, new int[][]
                {{0,1},{0,2},{1,3},{3,2},{3,4}}, 0, 4));
    }
}
//[[0,1],[0,3],[1,2],[2,1]]
//[[0,1],[0,2],[1,3],[2,3]]
