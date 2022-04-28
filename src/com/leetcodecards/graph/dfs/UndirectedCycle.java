package com.leetcodecards.graph.dfs;

import java.util.*;

public class UndirectedCycle {

    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int curr, int par, boolean[] visited) {
        visited[curr] = true;

        if (adj.get(curr) != null)
            for (int child : adj.get(curr)) {
                if (child != par && (visited[child] || dfs(adj, child, curr, visited)))
                    return true;
            }

        return false;
    }

    // Function to detect cycle in a directed graph.
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v];

        for(int i = 0; i < v; i++) {
            if(adj.get(i) != null) {
                if (!visited[i] && dfs(adj, i, -1, visited))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        UndirectedCycle abc = new UndirectedCycle();
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        edges.add(new ArrayList<>(Arrays.asList(0,1)));
        edges.add(new ArrayList<>(Arrays.asList(1,0)));

        edges.add(new ArrayList<>(Arrays.asList(1,2)));
        edges.add(new ArrayList<>(Arrays.asList(2,1)));

        edges.add(new ArrayList<>(Arrays.asList(2,3)));
        edges.add(new ArrayList<>(Arrays.asList(3,2)));

        edges.add(new ArrayList<>(Arrays.asList(4,2)));
        edges.add(new ArrayList<>(Arrays.asList(2,4)));

        /*edges.add(new ArrayList<>(Arrays.asList(2,0)));
        edges.add(new ArrayList<>(Arrays.asList(0,2)));*/

        System.out.println(abc.isCycle(5, edges));
    }
}
