package com.leetcodecards.graph.dfs;

import java.util.*;

public class DetectCycle {
    static final int BLACK = 2, GREY = 1, WHITE = 0;
    int[] visited;

    public boolean dfsDirected(int curr, ArrayList<ArrayList<Integer>> adj) {
        visited[curr] = GREY;

        for(int ne : adj.get(curr)) {
            if(visited[ne] == GREY)
                return true;
            else if(visited[ne] == WHITE)
                if(dfsDirected(ne, adj))
                    return true;
        }

        visited[curr] = BLACK;
        return false;
    }

    public boolean isCyclicDirected(int V, ArrayList<ArrayList<Integer>> adj) {

        visited = new int[V];

        for(int i = 0; i < V; i++)
            if(visited[i] == WHITE && dfsDirected(i, adj))
                return true;

        return false;
    }


    public boolean dfsUndirected(int curr, ArrayList<ArrayList<Integer>> adj) {
        visited[curr] = GREY;

        for(int ne : adj.get(curr)) {
            if(visited[ne] == BLACK)
                return true;
            else if(visited[ne] == WHITE)
                if(dfsUndirected(ne, adj))
                    return true;
        }

        visited[curr] = BLACK;
        return false;
    }

    public boolean isCycleUndirected(int V, ArrayList<ArrayList<Integer>> adj) {
        visited = new int[V];

        for(int i = 0; i < V; i++)
            if(visited[i] == WHITE && dfsUndirected(i, adj))
                return true;

        return false;

    }

    public static void main(String[] args) {
        DetectCycle abc = new DetectCycle();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>(Arrays.asList(1)));
        list.add(new ArrayList<>(Arrays.asList(0)));
        list.add(new ArrayList<>(Arrays.asList(3)));
        list.add(new ArrayList<>(Arrays.asList()));


        System.out.println("IsCyclic " + abc.isCyclicDirected(4, list));
    }
}
