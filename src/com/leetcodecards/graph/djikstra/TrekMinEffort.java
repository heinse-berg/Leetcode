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
            Cell currentCell = pq.poll();
            int x = currentCell.x;
            int y = currentCell.y;

            if(!visited[x][y]) {
                for(Cell neighbor : getNeighbors(currentCell)) {
                    int neighborDiff = Math.abs(heights[x][y] - heights[neighbor.x][neighbor.y]);
                    if(neighborDiff < neighbor.difference) {
                        neighbor.difference = neighborDiff;
                        cost[neighbor.x][neighbor.y] = neighborDiff;
                        pq.add(new Cell(neighbor.x, neighbor.y, neighborDiff));
                    }
                }
                visited[x][y] = true;
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
