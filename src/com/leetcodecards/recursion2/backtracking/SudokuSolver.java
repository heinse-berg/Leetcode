package com.leetcodecards.recursion2.backtracking;

import java.util.*;

public class SudokuSolver {

    char[][] board;
    boolean solved = false;

    public boolean isSafe(int i, int j) {
        char toCheck = board[i][j];
        board[i][j] = '.';

        //row
        for(int row = 0; row < 9; row++)
            if(board[row][j] == toCheck) {
                board[i][j] = toCheck;
                return false;
            }

        //col
        for(int col = 0; col < 9; col++)
            if(board[i][col] == toCheck) {
                board[i][j] = toCheck;
                return false;
            }

        //subMatrix
        int boxRowOffSet = (i/3)*3;
        int boxColOffSet = (j/3)*3;
        for(int row=0; row<3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[boxRowOffSet + row][boxColOffSet + col] == toCheck) {
                    board[i][j] = toCheck;
                    return false;
                }
            }
        }

        board[i][j] = toCheck;
        return true;
    }

    public void backtrack(int row, int col) {

        if(row == 8 && col == 9) {
            solved = true;
            return;
        }
        if(!solved) {
            for (int i = row; i < 9; i++) {
                if(!solved) {
                    for (int j = col; j < 9; j++) {
                        if(!solved) {
                            if (board[i][j] == '.') {
                                for (int k = 0; k < 9; k++) {
                                    board[i][j] = (char) (k + '0');
                                    if (isSafe(i, j)) {
                                        backtrack(i, j);
                                    }
                                    board[i][j] = '.';
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public void solveSudoku(char[][] board) {
        this.board = board;
        backtrack(0, 0);
    }

    public static void main(String[] args) {
        char[][] sudoku = new char[][]
                       {{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
       /* solveSudoku(sudoku, 9);
        Arrays.stream(sudoku).forEach( a -> System.out.println(Arrays.toString(a)));*/
        SudokuSolver s = new SudokuSolver();
        s.solveSudoku(sudoku);
        System.out.println();
    }
}
