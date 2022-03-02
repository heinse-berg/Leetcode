package com.leetcodecards.graph.djikstra;

import java.util.*;

public class TrekMinEffort {

    static class Cell {
        int x;
        int y;
        int difference;

        public Cell(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.difference = weight;
        }
    }

    public List<Cell> getNeighbors(Cell cell) {
        LinkedList<Cell> list = new LinkedList<>();

        for(int[] direction : directions) {
            int newX = cell.x + direction[0];
            int newY = cell.y + direction[1];
            if(newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY])
                list.add(new Cell(newX, newY, cost[newX][newY]));
        }

        return list;
    }

    boolean[][] visited;
    int[][] directions = new int[][] {{0,-1}, {-1,0}, {0,1}, {1,0}};
    int[][] cost;
    int rows, cols;

    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length, cols = heights[0].length;
        this.cost = new int[rows][cols];
        for(int[] arr : cost)
            Arrays.fill(arr, Integer.MAX_VALUE);
        this.visited = new boolean[rows][cols];
        this.rows = rows; this.cols = cols;
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(cell -> cell.difference));

        pq.add(new Cell(0, 0, 0));
        cost[0][0] = 0;

        while(!pq.isEmpty()) {
            Cell curr = pq.poll();
            visited[curr.x][curr.y] = true;

            for(Cell cell : getNeighbors(curr)) {
                int x = cell.x, y = cell.y;
                if(!visited[x][y]) {
                    int diff = Math.max(curr.difference, Math.abs(heights[curr.x][curr.y] - heights[x][y]));
                    if(cell.difference > diff) {
                        cost[x][y] = diff;
                        cell.difference = diff;
                        pq.add(cell);
                    }
                }
            }
        }

        return cost[rows-1][cols-1];
    }

    public static void main(String[] args) {
        TrekMinEffort abc = new TrekMinEffort();
        System.out.println(abc.minimumEffortPath(new int[][] {
                {1,2,2}, {3,8,2}, {5,3,5}
        }));
    }
    //[[1,2,2],[3,8,2],[5,3,5]]
}
