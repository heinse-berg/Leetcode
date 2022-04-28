package com.playground;

import java.util.Arrays;
import java.util.Collections;

public class Uber {
    //https://leetcode.com/discuss/interview-question/1889527/OA-Uber

    public int consecutiveTriples(int[] arr) {

        int i = 3, n = arr.length, sum = arr[0] + arr[1] + arr[2], ans = 0, prevSum;

        for(; i < n; i++) {
            prevSum = sum;
            sum = sum + arr[i] - arr[i-3] ;
            if(sum > prevSum)
                ans++;
        }

        return ans;
    }

    /* Traverse the sorted baits array, and try to use each bait to catch the biggest fish currently in the pond, until the bait expires after catching 3 fish
    Finish the algorithm where:
    1) there are no more fish in the pond, or
    2) when there are no more baits left, or
    3) when it's no longer possible to catch the any more fish with the remaining baits */

    public int fishBaits(Integer[] fish, Integer[] bait) {
        Arrays.sort(bait, Collections.reverseOrder());
        Arrays.sort(fish, Collections.reverseOrder());

        int i = 0, n = fish.length, m = bait.length, j = 0, ans = 0;

        while(i < n && j < m) {

            int ct = 0;
            while(i < n && fish[i] > bait[j] && ct < 3) {
                i++; ct++; ans++;
            }
            j++;
        }

        return ans;
    }

    int n, m;
    int[][] directions = new int[][] {{1,1}, {1,-1}, {-1,1}, {-1,-1}};

    public int dfs(int[][] matrix, int i, int j, int depth) {

        if((i == 0 || j == 0 || i == m-1 || j == n-1) && depth > 0)
            return 1;

        int ans = 0;

        for(int[] d : directions) {
            int x = d[0] + i, y = d[1] + j;

            if(x >= 0 && y >= 0 && x < m && y < n) {
                if(matrix[i][j] == 0 && depth > 0) {
                    if (matrix[x][y] == 2)
                        ans = Math.max(ans, 1 + dfs(matrix, x, y, depth+1));
                }
                else if(matrix[i][j] == 1 && depth == 0) {
                    if (matrix[x][y] == 2)
                        ans = Math.max(ans, 1 + dfs(matrix, x, y, depth+1));
                }
                else {
                    if(matrix[x][y] == 0 && depth > 0)
                        ans = Math.max(ans, 1 + dfs(matrix, x, y, depth+1));
                }
            }
        }

        return ans;
    }

    public int diagonal(int[][] matrix) {
        n = matrix[0].length; m = matrix.length;
        int ans = 0;

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                ans = Math.max(ans, dfs(matrix, i, j, 0));

        return ans;
    }

    public static void main(String[] args) {
        Uber abc = new Uber();

        //System.out.println(abc.fishBaits(new Integer[] { 20, 10, 5}, new Integer[] { 12, 40 } ));
        System.out.println(abc.diagonal(
                new int[][]
                {{0, 0, 1, 2},
                {0, 2, 2, 2},
                {2, 1, 0, 1}} ));
    }
}
