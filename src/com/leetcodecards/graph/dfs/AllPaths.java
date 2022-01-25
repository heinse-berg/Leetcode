package com.leetcodecards.graph.dfs;

import java.util.*;

public class AllPaths {

    ArrayList<ArrayList<Integer>> adjacencyList;
    List<List<Integer>> res = new ArrayList<>();
    int destination;

    public void dfs(int node, LinkedList<Integer> list) {
        list.add(node);
        if(node == destination) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i : adjacencyList.get(node)) {
            dfs(i, list);
            list.removeLast();
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        adjacencyList = new ArrayList<>();
        int n = graph.length, i; this.destination = n-1;

        for(i = 0; i < n; i++)
            adjacencyList.add(new ArrayList<>());

        i = 0;
        for(int[] edge : graph) {
            ArrayList<Integer> l = adjacencyList.get(i++);
            for(int j : edge)
                l.add(j);
        }

        dfs(0, new LinkedList<>());
        return res;
    }

    public static void main(String[] args) {
        AllPaths abc = new AllPaths();
        System.out.println(abc.allPathsSourceTarget(new int[][] {{4,3,1},{3,2,4},{3},{4},{}}));
    }
}
//[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
