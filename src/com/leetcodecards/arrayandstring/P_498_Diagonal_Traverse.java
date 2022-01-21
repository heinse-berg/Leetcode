package com.leetcodecards.arrayandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P_498_Diagonal_Traverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int i, j, rows = mat.length, cols = mat[0].length, k, d = 0, diag = 0;
        int[] res = new int[rows*cols];
        ArrayList<Integer> intermediate = new ArrayList<>();
        for(j = 0; j < cols; j++) {
            i = 0; k = j;
            intermediate.clear();
            while(i < rows && k >= 0) {
                intermediate.add(mat[i][k]);
                i++; k--;
            }
            if((diag++) % 2 == 0)
                Collections.reverse(intermediate);
            for(int n : intermediate)
                res[d++] = n;
        }
        for(i = 1; i < rows; i++) {
            j = cols - 1; k = i;
            intermediate.clear();
            while(k < rows  && j >= 0) {
                intermediate.add(mat[k][j]);
                j--; k++;
            }
            if((diag++) % 2 == 0)
                Collections.reverse(intermediate);
            for(int n : intermediate)
                res[d++] = n;
        }
        return res;
    }

    public static void main(String[] args) {
        P_498_Diagonal_Traverse abc = new P_498_Diagonal_Traverse();
        System.out.println(Arrays.toString(abc.findDiagonalOrder(new int[][]{{2,5},{8,4},{0,-1}})));
    }
}
