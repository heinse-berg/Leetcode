package com.leetcodecards.queueStack;

import java.util.*;

public class ZeroOneMatrix {
    int[][] directions = new int[][] { {-1,0}, {1,0}, {0,1}, {0,-1} };

    public int[][] updateMatrix(int[][] mat) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int rows = mat.length, cols = mat[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++) {
                if(mat[i][j] == 0)
                    q.addLast(new int[] {i, j, 0});
                else
                    mat[i][j] = Integer.MAX_VALUE;
            }
        }

        while(!q.isEmpty()) {
            int currSize = q.size();

            while(currSize > 0) {
                int[] curr = q.pollFirst();
                int x = curr[0], y = curr[1], dist = curr[2];

                for(int[] direction : directions) {
                    int newX = direction[0] + x;
                    int newY = direction[1] + y;
                    if(newX >= 0 && newX < rows && newY >= 0 && newY < cols && mat[newX][newY] != 0) {
                        if(mat[newX][newY] > dist+1) {
                            mat[newX][newY] = dist + 1;
                            q.add(new int[]{newX, newY, dist + 1});
                        }
                    }
                }

                currSize--;
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        ZeroOneMatrix abc = new ZeroOneMatrix();
        System.out.println(Arrays.deepToString(abc.updateMatrix(new int[][]
                        {{0,0,0},{0,1,0},{1,1,1}}
                )));
    }
}
