package com.leetcodecards.hashing;

import java.util.*;

public class SudokuSolver {

    public boolean isValidSudoku(char[][] board) {

        ArrayList<HashSet<Character>> rows = new ArrayList<>();
        ArrayList<HashSet<Character>> cols = new ArrayList<>();
        ArrayList<HashSet<Character>> submatrices = new ArrayList<>();
        int i, j, temp;
        for(i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            submatrices.add(new HashSet<>());
        }

        for(i = 0; i < 9; i++) {
            for(j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c =='.')
                    continue;
                if(rows.get(i).contains(c))
                    return false;
                else
                    rows.get(i).add(c);
                if(cols.get(j).contains(c))
                    return false;
                else
                    cols.get(j).add(c);
                temp =  (i / 3) * 3 + j / 3;
                if(submatrices.get(temp).contains(c))
                    return false;
                else
                    submatrices.get(temp).add(c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver abc = new SudokuSolver();
        System.out.println(abc.isValidSudoku(   new char[][]
                       {{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}}  ));
    }
}
