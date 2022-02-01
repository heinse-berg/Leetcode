package com.leetcodecards.graph.dfs;

import java.util.*;

public class DetectCycle {

    boolean[] seen;
    ArrayList<ArrayList<Integer>> adj;

    public boolean dfs(int curr) {
        if(seen[curr])
            return true;
        seen[curr] = true;
        for(int neighbor : adj.get(curr)) {
            if(dfs(neighbor))
                return true;
        }
        return false;
    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        this.seen = new boolean[V];
        this.adj = adj;

        return dfs(0);
    }

    public static void main(String[] args) {
        DetectCycle abc = new DetectCycle();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>(Arrays.asList(1)));
        list.add(new ArrayList<>(Arrays.asList(0)));
        list.add(new ArrayList<>(Arrays.asList(3)));
        list.add(new ArrayList<>(Arrays.asList()));


        System.out.println("IsCyclic " + abc.isCyclic(4, list));
    }
}
