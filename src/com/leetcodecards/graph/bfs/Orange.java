package com.leetcodecards.graph.bfs;

import java.util.*;

public class Orange {


    int[][] directions = new int[][] {{0,-1},{-1,0},{0,1},{1,0}};
    int m, n, fresh = 0;

    public List<int[]> getNeighbors(int[] cell, int[][] grid) {
        List<int[]> list = new ArrayList<>();
        for(int[] direction : directions) {
            int newRow = cell[0] + direction[0];
            int newCol = cell[1] + direction[1];
            if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                list.add(new int[] {newRow, newCol});
                fresh--;
                grid[newRow][newCol] = 2;
            }
        }
        return list;
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length, depth  = 0;
        this.m = m; this.n = n;
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1)
                    fresh++;
                else if(grid[i][j] == 2)
                    queue.addLast(new int[] {i, j});
            }
        }

        while(!queue.isEmpty()) {
            int currSize = queue.size();
            for(int i = 0; i < currSize; i++) {
                int[] cell = queue.pollFirst();
                for(int[] neighbor : getNeighbors(cell, grid)) {
                    queue.addLast(neighbor);
                }
            }
            if(!queue.isEmpty())
                depth++;
        }

        return fresh == 0 ? depth : -1;
    }

    public static void main(String[] args) {
        Orange abc = new Orange();
        System.out.println(abc.orangesRotting(new int[][] {{2,1,1},{1,1,0},{0,1,1}}));
    }
}
