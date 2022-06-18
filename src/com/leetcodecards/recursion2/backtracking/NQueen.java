package com.leetcodecards.recursion2.backtracking;

import java.util.*;
import java.util.function.IntFunction;

public class NQueen {

    boolean[] rows, cols, diags, antiDiags;
    ArrayList<List<String>> res = new ArrayList<>();
    int n;
    IntFunction<Integer> antiDiagonals = a -> a < 0 ? Math.abs(a)+n : a;

    public boolean isSafe(int row, int col) {
        return !rows[row] && !cols[col] && !diags[row+col] && !antiDiags[antiDiagonals.apply(row-col)];
    }

    public void back(int col, ArrayList<StringBuilder> curr) {

        if(col == n) {
            res.add((ArrayList<String>) curr.clone());
            return;
        }

        for(int i = 0; i < n; i++) {

            if(isSafe(i, col)) {
                rows[i] = true; cols[col] = true; diags[i+col] = true; antiDiags[antiDiagonals.apply(i-col)] = true;
                curr.get(i).setCharAt(col, 'Q');
                back(col+1, curr);
                rows[i] = false; cols[col] = false; diags[i+col] = false; antiDiags[antiDiagonals.apply(i-col)] = false;
                curr.get(i).setCharAt(col, '.');
            }
        }

    }

    public List<List<String>> solveNQueens(int n) {

        rows = new boolean[n]; cols = new boolean[n]; diags = new boolean[2*n];  antiDiags = new boolean[2*n];
        this.n = n;

        ArrayList<StringBuilder> curr = new ArrayList<>();
        for(int i = 0; i < n ; i++) {
            curr.add(new StringBuilder());
            StringBuilder sb = curr.get(i);
            for(int j = 0; j < n; j++) {
                sb.append('.');
            }
        }

        back(0, curr);
        return res;
    }

    public static void main(String[] args) {
        NQueen abc = new NQueen();
        System.out.println(abc.solveNQueens(4));
    }
}
