package com.leetcodecards.queueStack;

import java.util.*;

public class FloodFill {

    int rows, cols;
    int [][] image;
    int toBeReplaced, newColor;

    public void dfs(int i, int j) {
        if(image[i][j] == toBeReplaced) {
            image[i][j] = newColor;
            if(i+1 < rows && image[i+1][j] == toBeReplaced) {
                dfs(i + 1, j);
            }
            if(j+1 < cols && image[i][j+1] == toBeReplaced) {
                dfs(i, j + 1);
            }
            if(i-1 >= 0 && image[i-1][j] == toBeReplaced) {
                dfs(i - 1, j);
            }
            if(j-1 >= 0 && image[i][j-1] == toBeReplaced) {
                dfs(i, j - 1);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.image = image; this.newColor = newColor; toBeReplaced = image[sr][sc];
        this.rows = image.length; this.cols = image[0].length;

        dfs(sr, sc);

        return image;
    }

    public static void main(String[] args) {
        FloodFill abc = new FloodFill();
        System.out.println(Arrays.deepToString(abc.floodFill(new int[][]{{0, 0, 0},
                {0, 1, 1}}, 1, 1, 1)));
    }
}
