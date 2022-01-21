package com.leetcodecards.recursion2;

import java.util.*;

public class Matrix2D {

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = 0, n = matrix.length, m = matrix[0].length, row, col, k;
        while(i < n)
            if(matrix[i][0] < target) i++;
            else break;
        while(j < m)
            if(matrix[0][j] < target) j++;
            else break;
        if(i > 0) i--;
        if(j > 0) j--;
        row = i; col = j;
        for(k = 0; k < m; k++)
            if(matrix[row][k] == target) return true;
        for(k = 0; k < n; k++)
            if(matrix[k][col] == target) return true;
        return false;
    }
//[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]
    public static void main(String[] args) {
        Matrix2D abc = new Matrix2D();
        //int[][] a = new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] a = new int[][] {{1,3,5,7,9},{2,4,6,8,10},{11,13,15,17,19},{12,14,16,18,20},{21,22,23,24,25}};
        System.out.println(abc.searchMatrix(a, 13));
    }
}
