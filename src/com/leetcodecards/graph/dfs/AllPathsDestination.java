package com.leetcodecards.graph.dfs;

import java.util.*;

public class AllPathsDestination {
    HashMap<Integer, HashSet<Integer>> map;
    boolean[] seen;
    int destination;

    public boolean dfs(int from) {
        if(from == destination)
            return map.get(destination) == null;

        if(seen[from])
            return false;

        seen[from] = true;
        HashSet<Integer> destinations = map.get(from);
        if(destinations == null)
            return false;

        for (Integer integer : destinations) {
            if(!dfs(integer))
                return false;
            seen[integer] = false;
        }
        return true;
    }

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        this.destination = destination;
        map = new HashMap<>();

        for(int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if(!map.containsKey(x))
                map.put(x, new HashSet<>());
            map.get(x).add(y);
        }
        this.seen = new boolean[n];
        return dfs(source);
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
