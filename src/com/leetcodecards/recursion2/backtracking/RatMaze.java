package com.leetcodecards.recursion2.backtracking;
/* Java program to solve Rat in
a Maze problem using backtracking */

import java.util.LinkedList;
import java.util.List;

public class RatMaze {

    // Size of the maze
    static int N;

    int[][] directions = new int[][] { {0,1}, {1,0}, {-1,0}, {0,-1} };

    void printSolution(int[][] sol)
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(
                        " " + sol[i][j] + " ");
            System.out.println();
        }
    }

    List<int[]> getNeighbors(
            int[][] maze, int x, int y)
    {
        LinkedList<int[]> list = new LinkedList<>();
        for(int[] d : directions) {
            int newX = d[0] + x, newY = d[1] + y;
            if(newX >= 0 && newY >= 0 && newX < N && newY < N && maze[newX][newY] == 1)
                list.addLast(new int[] {newX, newY});
        }
        return list;
    }

    boolean solveMaze(int[][] maze)
    {

        if (!solveMazeUtil(maze, 0, 0)) {
            System.out.print("Solution doesn't exist");
            return false;
        }

        printSolution(maze);
        return true;
    }

    boolean solveMazeUtil(int[][] maze, int x, int y)
    {
        // if (x, y is goal) return true
        if (x == N - 1 && y == N - 1
                && maze[x][y] == 1) {
            maze[x][y] = 2;
            return true;
        }

        maze[x][y] = 2;

        for(int[] neighbor : getNeighbors(maze, x, y))
            if(solveMazeUtil(maze, neighbor[0], neighbor[1]))
                return true;

        maze[x][y] = 1;

        return false;
    }

    public static void main(String[] args)
    {
        RatMaze rat = new RatMaze();
        int[][] maze = {
                { 1, 1, 1, 0 },
                { 0, 1, 0, 1 },
                { 0, 1, 0, 1 },
                { 1, 1, 1, 1 } };

        N = maze.length;
        rat.solveMaze(maze);
    }
}