package com.leetcodecards.recursion2.backtracking;

import java.util.*;

public class NQueen {

    int[][] board;
    int n;
    int ans = 0;

    public boolean isSafe(int i, int j) {
        //row
        for(int k = 0; k < n; k++)
            if(board[i][k] == 1)
                return false;

        //column
        for(int k = 0; k < n; k++)
            if(board[k][j] == 1)
                return false;

        //anti-diagonal
        int k = i-1, l = j+1;
        while(k >= 0 && l < n) {
            if(board[k][l] == 1)
                return false;
            k--;    l++;
        }
        k = i+1; l = j-1;
        while(k < n && l >= 0) {
            if(board[k][l] == 1)
                return false;
            k++;    l--;
        }

        //diagonal
        k = i-1; l = j-1;
        while(k >= 0 && l >= 0) {
            if(board[k][l] == 1)
                return false;
            k--;    l--;
        }
        k = i+1; l = j+1;
        while(k < n && l < n) {
            if(board[k][l] == 1)
                return false;
            k++;    l++;
        }

        return true;
    }

    public void backtrack(int col) {
        if(col == n) {
            ans++;
        }

        for(int row = 0; row < n; row++) {
            if (isSafe(row, col)) {
                board[row][col] = 1;
                backtrack(col+1);
                board[row][col] = 0;
            }
        }

    }

    public void solveNQueens(int n) {
        board = new int[n][n];
        this.n = n;
        backtrack(0);
    }

    public static void main(String[] args) {
        NQueen abc = new NQueen();
        abc.solveNQueens(6);
        System.out.println(abc.ans);
    }
}
