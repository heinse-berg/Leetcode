package com.leetcodecards.recursion2.backtracking;

public class NQueenProblem {
    final int N = 4;
    void printSolution(int board[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
    }

    boolean isSafe(int[][] board, int row, int col) {
        int i, j;
        for(i = 0; i < col; i++)
            if(board[row][i] == 1)
                return false;
        for(i = row-1, j = col-1; i >= 0 && j >= 0; i--,j--)
            if(board[i][j] == 1)
                return false;
        for(i = row+1, j = col-1; i <= N-1 && j >= 0; i++,j--)
            if(board[i][j] == 1)
                return false;
        return true;
    }

    boolean solveNQ() {
        int[][] board = { { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };

        if (!solveNQUtil(board, 0)) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }

    boolean solveNQUtil(int[][] board, int col) {
        if(col == N)
            return true;
        for(int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if(solveNQUtil(board, col+1))
                    return true;
                board[i][col] = 0;
            }
        }
        return false;
    }

    // driver program to test above function
    public static void main(String args[])
    {
        NQueenProblem Queen = new NQueenProblem();
        Queen.solveNQ();
    }
}
