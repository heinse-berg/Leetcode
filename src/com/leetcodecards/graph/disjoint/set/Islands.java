package com.leetcodecards.graph.disjoint.set;

import com.leetcodecards.graph.djikstra.TrekMinEffort;

import java.util.*;

public class Islands {
    int rows, cols, count;
    char[][] grid;

    public void dfs(int i, int j) {
        grid[i][j] = '0';
        if(i+1 < rows && grid[i+1][j] == '1')
            dfs(i+1, j);
        if(j+1 < cols && grid[i][j+1] == '1')
            dfs(i, j+1);

    }

    public int numIslands(char[][] grid) {
        rows = grid.length; cols = grid[0].length;
        this.grid = grid;

        for(int i = 0; i < cols; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '1') {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Islands abc = new Islands();
        System.out.println(abc.numIslands(new char[][]
                        {{'1','1','0','0','0'},
                          {'1','1','0','0','0'},
                          {'0','0','1','0','0'},
                          {'0','0','0','1','1'}}
                ));
    }
}
