package com.leetcodecards.recursion2.backtracking;

import java.util.*;

public class NQueen {

    int[][] board;
    int n;
    int ans = 0;
    HashSet<Integer> rows = new HashSet<>();
    HashSet<Integer> diags = new HashSet<>();
    HashSet<Integer> antiDiags = new HashSet<>();

    public boolean isSafe(int i, int j) {
        return !rows.contains(i) && !diags.contains(i + j) && !antiDiags.contains(i - j);
    }

    public void backtrack(int col) {
        if(col == n) {
            ans++;
        }

        for(int row = 0; row < n; row++) {
            if (isSafe(row, col)) {
                rows.add(row); diags.add(col + row); antiDiags.add(row - col);
                backtrack(col+1);
                rows.remove(row); diags.remove(col + row); antiDiags.remove(row - col);
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
