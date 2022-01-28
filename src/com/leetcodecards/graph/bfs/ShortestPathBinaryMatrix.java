package com.leetcodecards.graph.bfs;

import java.util.*;

public class ShortestPathBinaryMatrix {

    int[][] directions = new int[][] {{-1,0},{-1,-1},{0,-1},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
    int rows, cols;
    boolean[][] visited;

    public List<int[]> getNeighbours(int[] cell, int[][] grid) {
        List<int[]> neighbors = new LinkedList<>();
        int currentRow = cell[0];
        int currentCol = cell[1];
        for(int[] direction : directions) {
            int newRow = currentRow + direction[0];
            int newCol = currentCol + direction[1];
            if((newRow >= 0 && newRow <= rows && newCol >= 0 && newCol <= cols && grid[newRow][newCol] == 0))
                neighbors.add(new int[]{newRow, newCol});
        }
        return neighbors;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length-1, cols = grid[0].length-1, currentDistance = 1;
        this.rows = rows; this.cols = cols;
        if(grid[0][0] != 0 || grid[rows][cols] != 0) return -1;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visited = new boolean[rows+1][cols+1];

        queue.addLast(new int[] {0,0});

        while(!queue.isEmpty()) {
            int currentSize = queue.size();

            for(int i = 0; i < currentSize; i++) {
                int[] currentCell = queue.pollFirst();
                int row = currentCell[0];
                int col = currentCell[1];
                if(row == rows && col == cols && grid[row][cols] == 0)
                    return currentDistance;

                for(int[] neighbour : getNeighbours(currentCell, grid)) {
                    if(!visited[neighbour[0]][neighbour[1]]) {
                        queue.addLast(neighbour);
                        visited[neighbour[0]][neighbour[1]] = true;
                    }
                }
            }
            currentDistance++;
        }
        return -1;
    }

    public static void main(String[] args) {
        ShortestPathBinaryMatrix abc = new ShortestPathBinaryMatrix();
        System.out.println(abc.shortestPathBinaryMatrix(new int[][]{{0,1},{1,0}}));
    }
}
