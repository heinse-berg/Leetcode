package com.leetcodecards.matrix.traversal;

import java.util.*;

public class Spiral {

    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length, m =  matrix[0].length, total = n * m;
        LinkedList<Integer> list = new LinkedList<>();
        int[][] directions = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int visited = 101, currentDirections = 0, newX = 0, newY = 0;

        while(total > 0) {
            int x = directions[currentDirections][0], y = directions[currentDirections][1];

            while(newX < n && newX >= 0 && newY >= 0 && newY < m && matrix[newX][newY] != visited) {
                list.add(matrix[newX][newY]);
                matrix[newX][newY] = visited;
                newX = newX + x; newY = newY + y;
                total--;
            }

            newX = newX-directions[currentDirections][0]; newY = newY-directions[currentDirections][1];
            currentDirections = (currentDirections+1) % 4;
            newX = newX+directions[currentDirections][0]; newY = newY+directions[currentDirections][1];
        }

        return list;
    }

    public static void main(String[] args) {
        Spiral abc = new Spiral();
        System.out.println();
    }
}
