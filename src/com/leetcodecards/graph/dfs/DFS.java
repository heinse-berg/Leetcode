package com.leetcodecards.graph.dfs;

import java.util.*;

public class DFS {
    boolean[][] graph;
    int source; int destination; int n;
    boolean[] seen;

    boolean dfs(int i) {
        if(i == destination) {
            seen[i] = true;
            return true;
        }
        seen[i] = true;
        for(int j = 0; j < n; j++) {
            if (!seen[j]) {
                if (graph[i][j]) {
                    if(dfs(j))
                        return true;
                }
            }
        }
        return seen[i] = false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        graph = new boolean[n][n];
        this.source = source; this.destination = destination; this.n = n;
        int i;
        seen = new boolean[n];

        for(i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            graph[x][y] = true;
            graph[y][x] = true;
        }
        return dfs(source);
    }

    public static void main(String[] args) {
        DFS abc = new DFS();
        System.out.println(abc.validPath(5, new int[][]
                        {{4,0}, {0,1}, {0,3}, {4,2}},
                3, 2));
        System.out.println(Arrays.toString(abc.seen));
    }
}
//[20, 16, 70, 18, 6, 0, 21, 32, 8, 38, 31, 17, 14, 4, 99, 11, 7, 1, 36, 19, 30, 45, 27, 26, 24, 28, 54, 15, 63, 51, 9, 3, 12, 48, 58, 39, 60, 41, 46, 75, 67, 84, 64, 53]
