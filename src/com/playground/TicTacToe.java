package com.playground;

import java.util.*;

public class TicTacToe {

    int[][] rows, cols;
    int n;
    int[] diags = new int[3], antidiags = new int[3];

    public TicTacToe(int n) {
        this.n = n;
        rows = new int[3][n];
        cols = new int[3][n];
    }

    public int move(int row, int col, int player) {
        if(row == col)
            diags[player]++;
        if(row + col == n-1)
            antidiags[player]++;
        if(diags[player] == n || antidiags[player] == n)
            return player;

        rows[player][row]++;
        rows[player][col]++;

        if(rows[player][row] == n || rows[player][col] == n)
            return player;

        return 0;
    }

    public static void main(String[] args) {
        TicTacToe abc = new TicTacToe(3);
    }

    public long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        Collections.sort(a);
        long i = 0, j = i+m-1, ans = Long.MAX_VALUE;
        for(; j < n; i++, j++) {
            ans = Math.min(ans, a.get((int) j)-a.get((int) i));
        }
        return ans;
    }
}
