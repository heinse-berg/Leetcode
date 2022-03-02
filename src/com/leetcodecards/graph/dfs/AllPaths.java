package com.leetcodecards.graph.dfs;

import java.util.*;

public class AllPaths {

    ArrayList<LinkedList<Integer>> g;
    boolean[] seen;
    LinkedList<List<Integer>> res = new LinkedList<>();

    public void dfs(int source, LinkedList<Integer> curr, int destination) {
        if(source == destination) {
            res.add(new ArrayList<>(curr));
            return;
        }
        seen[source] = true;

        for(int neigh : g.get(source)) {
            if(!seen[neigh]) {
                curr.addLast(neigh);
                dfs(neigh, curr, destination);
                curr.removeLast();
            }
        }

        seen[source] = false;
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int i, n = graph.length;
        g = new ArrayList<>(n);
        seen = new boolean[n];

        for(i = 0; i < n; i++)
            g.add(new LinkedList<>());

        i = 0;
        for(int[] edge : graph) {
            for(int j : edge) {
                g.get(i).add(j);
                g.get(j).add(i);
            }
            i++;
        }

        dfs(0, new LinkedList<>(Collections.singletonList(0)), n-1);

        return res;

    }

    public static void main(String[] args) {
        AllPaths abc = new AllPaths();
        System.out.println(abc.allPathsSourceTarget(new int[][] {{4,3,1},{3,2,4},{3},{4},{}}));
    }
}
//[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
