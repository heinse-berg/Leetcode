package com.leetcodecards.matrix.traversal;

import java.util.*;

public class DiagonalTraversal {

    public int[] findDiagonalOrder(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length, total = rows*cols, currentDirections = 0, newX = 0, newY = 0, i = 0;
        int[][] directions = new int[][] {{-1,1}, {1,-1}};
        int[] res = new int[rows*cols];

        while(total > 0) {
            int x = directions[currentDirections][0], y = directions[currentDirections][1];

            while(newX < rows && newX >= 0 && newY >= 0 && newY < cols) {
                res[i] = matrix[newX][newY];
                newX = newX + x; newY = newY + y;
                total--;
            }
            newX = newX-directions[currentDirections][0]; newY = newY-directions[currentDirections][1];
            currentDirections = (currentDirections+1) % 2;
        }

        return res;
    }

    public static void main(String[] args) {
        DiagonalTraversal abc = new DiagonalTraversal();
        System.out.println();
    }
}
