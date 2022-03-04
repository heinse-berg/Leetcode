package com.leetcodecards.graph.dfs;

import javafx.util.Pair;

import java.util.*;

public class PacificAtlantic {

    int m,n;
    LinkedList<List<Integer>> res = new LinkedList<>();
    int[][] heights;
    int[][] directions = new int[][] { {0,1}, {1,0}, {-1,0}, {0,-1}};
    boolean[][] visited;

    public void dfs(int x, int y, HashSet<Pair<Integer, Integer>> set) {
        set.add(new Pair<>(x, y));
        visited[x][y] = true;

        for(int[] direction : directions) {
            int newX = direction[0] + x;
            int newY = direction[1] + y;
            if(newX >= 0 && newX < m && newY >= 0 && newY < n && heights[newX][newY] >= heights[x][y] &&
                    !visited[newX][newY]) {
                dfs(newX, newY, set);
            }
        }

    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length; n = heights[0].length;
        this.heights = heights;
        visited = new boolean[m][n];
        HashSet<Pair<Integer, Integer>> pacific = new HashSet<>();
        HashSet<Pair<Integer, Integer>> atlantic = new HashSet<>();

        for(int i = 0; i < n; i++)
            dfs(0, i, pacific);
        for(int i = 0; i < m; i++)
            dfs(i, 0, pacific);


        visited = new boolean[m][n];
        for(int i = 0; i < n; i++)
            dfs(m-1, i, atlantic);
        for(int i = 0; i < m; i++)
            dfs(i, n-1, atlantic);

        atlantic.retainAll(pacific);

        for(Pair<Integer, Integer> pair : atlantic)
            res.addLast(Arrays.asList(pair.getKey(), pair.getValue()));

        return res;
    }

    public static void main(String[] args) {
        PacificAtlantic abc = new PacificAtlantic();
        System.out.println();
    }
}
