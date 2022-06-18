package com.leetcodecards.recursion2.backtracking;

import java.util.*;
import java.util.function.BiFunction;

public class SudokuSolver {

    ArrayList<HashSet<Character>> rows = new ArrayList<>(), cols = new ArrayList<>(), sub = new ArrayList<>();
    static final char[] ARRAY = new char[] {'1','2','3','4','5','6','7','8','9'};
    static final BiFunction<Integer, Integer, Integer> SUB_MATRIX_MAPPER = (a, b) -> (a/3)*3 + b/3;
    int count = 0;
    char[][] board;
    boolean sudokuSolve = false;

    public boolean isSafe(int row, int col, char digit) {
        return !rows.get(row).contains(digit) && !cols.get(col).contains(digit) && !sub.get(SUB_MATRIX_MAPPER.apply(row, col)).contains(digit);
    }


    public void backtrack(char[][] board, int row, int col) {

        if(row == 9) {
            sudokuSolve = count == 81;
            return;
        }

        for(int i = row; i < 9; i++) {
            for(int j = col; j < 9; j++) {
                if(board[i][j] == '.') {
                    for(char c : ARRAY) {
                        if(isSafe(i, j, c)) {
                            board[i][j] = c;
                            rows.get(i).add(c); cols.get(j).add(c); sub.get(SUB_MATRIX_MAPPER.apply(i, j)).add(c);
                            count++;
                            backtrack(board, i, j + 1);
                            if(sudokuSolve)
                                return;
                            board[i][j] = '.';
                            count--;
                            rows.get(i).remove(c); cols.get(j).remove(c); sub.get(SUB_MATRIX_MAPPER.apply(i, j)).remove(c);
                        }
                    }
                }
            }
        }

    }

    public void init(char[][] board) {

        for(int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            sub.add(new HashSet<>());
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    rows.get(i).add(board[i][j]); cols.get(j).add(board[i][j]); sub.get(SUB_MATRIX_MAPPER.apply(i, j)).add(board[i][j]);
                    count++;
                }
            }
        }
    }

    public void solveSudoku(char[][] board) {
        this.board = board;
        init(board);
        backtrack(board, 0, 0);
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
        System.out.println(Arrays.deepToString(sudoku));
    }
}
