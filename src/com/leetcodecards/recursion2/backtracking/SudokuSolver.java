package com.leetcodecards.recursion2.backtracking;

import java.util.*;

public class SudokuSolver {
    static int n = 9;
    static List<Character> set = Arrays.asList('1','2','3','4','5','6','7','8','9');

    public static boolean isSafe(char[][] board, int row, int col, char curr) {
        /* 3 checks are required
        first check: same row */
        int i, j, subRow, subCol;
        for(j = 0; j < n; j++)
            if(j != col && board[row][j] == curr)
                return false;
        //second check: same col
        for(i = 0; i < n; i++)
            if(i != row && board[i][col] == curr)
                return false;
        //third check: same sub-matrix. dimensions : 3*3
        subRow = row-(row%3); subCol = col-(col%3);
        for(i = subRow; i < subRow+3; i++)
            for(j = subCol; j < subCol+3; j++)
                if(board[i][j] == curr && !(i == row && j == col))
                    return false;

        return true;
    }

    public static boolean solveSudoku(char[][] board, int n) {
        int row = -1; int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '0') {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        if (isEmpty)
            return true;

        for (char num : set) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, n))
                    return true;
                else
                    board[row][col] = '0';
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] sudoku = new char[][]
                        {{'5', '3', '0', '0', '7', '0', '0', '0', '0'},
                        {'6', '0', '0', '1', '9', '5', '0', '0', '0'},
                        {'0', '9', '8', '0', '0', '0', '0', '6', '0'},
                        {'8', '0', '0', '0', '6', '0', '0', '0', '3'},
                        {'4', '0', '0', '8', '0', '3', '0', '0', '1'},
                        {'7', '0', '0', '0', '2', '0', '0', '0', '6'},
                        {'0', '6', '0', '0', '0', '0', '2', '8', '0'},
                        {'0', '0', '0', '4', '1', '9', '0', '0', '5'},
                        {'0', '0', '0', '0', '8', '0', '0', '7', '9'}};
        solveSudoku(sudoku, 9);
        Arrays.stream(sudoku).forEach( a -> System.out.println(Arrays.toString(a)));
    }
}
