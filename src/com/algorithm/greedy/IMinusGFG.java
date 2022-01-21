package com.algorithm.greedy;

import java.util.Arrays;
import java.util.Collections;

//https://practice.geeksforgeeks.org/problems/maximum-sum-of-increasing-order-elements-from-n-arrays4848/1/?category[]=Greedy&category[]=Greedy&page=1&query=category[]Greedypage1category[]Greedy
public class IMinusGFG {

    public int maximumSum (int n, int m, int arr[][]) {
        //Complete the function
        for(int i = 0; i < n; i++)
            arr[i] = Arrays.stream(arr[i]).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int maxSum = arr[n-1][0], prevMax = maxSum, i, j;
        for(i = n-2; i >= 0; i--) {
            for(j = 0; j < m; j++)
                if(arr[i][j] < prevMax) {
                    maxSum += arr[i][j];
                    prevMax = arr[i][j];
                    break;
                }
            if(j == m)
                return 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int [][] arr = {{1,7,4,3}, {4,2,5,1}, {9,5,1,8}};
        System.out.println(new IMinusGFG().maximumSum(arr.length, arr[0].length, arr));
    }
}
