package com.leetcodecards.matrix.traversal;

import java.util.*;

public class CommonElements {

    public HashSet<Integer> common(int[][] matrix) {

        HashSet<Integer> ans = new HashSet<>(), temp;
        int m = matrix.length, n = matrix[0].length;

        Arrays.stream(matrix[0]).forEach(ans::add);

        for(int i = 1; i < m; i++) {
            temp = new HashSet<>();
            for(int j = 0; j < n; j++)
                if(ans.contains(matrix[i][j]))
                    temp.add(matrix[i][j]);

            ans = temp;
            if(ans.isEmpty())
                return ans;
        }

        return ans;
    }

    public static void main(String[] args) {
        CommonElements abc = new CommonElements();
        System.out.println(abc.common(new int[][] {
                {1, 2, 1, 4, 8},
                {3, 7, 8, 5, 1},
                {8, 7, 7, 3, 1},
                {6, 2, 7, 9, 7},    }));
    }
}
