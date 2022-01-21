package com.leetcodecards.arrayandstring;

import java.util.*;

public class P_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int rows = matrix.length, cols = matrix[0].length, rowBoundUp = 0, rowBoundDown = rows, colBoundRight = cols, colBoundLeft = 0, count = 1, i, j;
        boolean right = true, down = true;
        while(count <= rows*cols) {
            if (right) {
                for(j = colBoundLeft; j < colBoundRight; j++) {
                    result.add(matrix[rowBoundUp][j]);
                    count++;
                }
                colBoundRight--;
                right = !right;
            }
            else {
                for(j = colBoundRight-1; j >= colBoundLeft; j--) {
                    result.add(matrix[rowBoundDown][j]);
                    count++;
                }
                colBoundLeft++;
                right = !right;
            }
            if(down) {
                for(i = rowBoundUp+1; i < rowBoundDown; i++) {
                    result.add(matrix[i][colBoundRight]);
                    count++;
                }
                rowBoundDown--;
                down = !down;
            }
            else {
                for(i = rowBoundDown-1; i > rowBoundUp; i--) {
                    result.add(matrix[i][colBoundLeft - 1]);
                    count++;
                }
                rowBoundUp++;
                down = !down;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        P_54 abc = new P_54();
        System.out.println(abc.spiralOrder(new int[][] {{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(abc.spiralOrder(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
        //[1,2,3,6,9,8,7,4,5] [1,2,3,4,8,12,11,10,9,5,6,7]
    }
}
