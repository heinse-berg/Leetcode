package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class LongestIncreasingPath {

    public int[][] directions = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public boolean[][] visited;
    int m, n;

    public int dfs(int i, int j, int[][] matrix) {

        visited[i][j] = true;
        int ans = 0;

        for(int[] d : directions) {
            int curr = 1;
            int newX = d[0] + i; int newY = d[1] + j;
            if(newX >= 0 && newY >= 0 && newX < m && newY < n && !visited[newX][newY] && matrix[newX][newY] > matrix[i][j])
                curr += dfs(newX, newY, matrix);
            ans = Math.max(ans, curr);
        }

        return ans;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0; m = matrix.length; n = matrix[0].length;

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++) {
                visited = new boolean[m][n];
                ans = Math.max(ans, dfs(i, j, matrix));
            }

        return ans;
    }

    public static void main(String[] args) {
        LongestIncreasingPath abc = new LongestIncreasingPath();
        System.out.println(abc.longestIncreasingPath(new int[][]
                {{7,8,9},{9,7,6},{7,2,3}} ));
        //[[7,8,9],[9,7,6],[7,2,3]]
    }
}
