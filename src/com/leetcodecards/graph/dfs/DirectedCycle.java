package com.leetcodecards.graph.dfs;

import java.util.*;

public class DirectedCycle {

    Colors[] visited;

    enum Colors {
        BLACK,
        WHITE,
        GREY
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int curr) {
        visited[curr] = Colors.GREY;

        if(adj.get(curr) != null)
            for(int child : adj.get(curr))
                if(visited[child] == Colors.GREY || (visited[child] == Colors.WHITE && dfs(adj, child)))
                    return true;

        visited[curr] = Colors.BLACK;
        return false;
    }

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        visited = new Colors[v];
        Arrays.fill(visited, Colors.WHITE);

        for(int i = 0; i < v; i++)
            if(adj.get(i) != null)
                if(visited[i] == Colors.WHITE && dfs(adj, i))
                    return true;

        return false;
    }

    public static void main(String[] args) {
        DirectedCycle abc = new DirectedCycle();
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(0,1)));
        edges.add(new ArrayList<>(Arrays.asList(1,2)));
        edges.add(new ArrayList<>(Arrays.asList(2,3)));
        edges.add(new ArrayList<>(Arrays.asList(4,2)));
        edges.add(new ArrayList<>(Arrays.asList(2,0)));
        System.out.println(abc.isCyclic(5, edges));
        //0 1
        //1 2
        //2 3
        //3 3
    }
}
