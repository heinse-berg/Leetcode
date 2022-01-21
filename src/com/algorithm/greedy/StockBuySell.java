package com.algorithm.greedy;

import java.util.ArrayList;

public class StockBuySell {

    ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        for(int i = 0; i <= A.length - 2; ) {
            ArrayList<Integer> ans = new ArrayList<>();
            while(i <= A.length - 2 && A[i+1] <= A[i])
                i++;
            if (i == A.length - 1)
                break;
            ans.add(A[i++]);
            while ((i < A.length) && (A[i] >= A[i - 1]))
                i++;
            ans.add(A[i-1]);
            answer.add(ans);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] a = new int[] {100,180,260,310,40,535,695};
        //int[] a = {4, 2, 3, 2, 4};
        System.out.println(new StockBuySell().stockBuySell(a, 7));
    }

}
