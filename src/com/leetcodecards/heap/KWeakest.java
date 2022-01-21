package com.leetcodecards.heap;

import javafx.util.Pair;

import java.util.*;

public class KWeakest {
    int n;

    public int binarySearch(int[] row) {
        int low = 0, high = n-1, mid;
        while(low < high) {
            mid = low+(high-low)/2;
            if(row[mid] == 1)
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
            if(a.getKey() > b.getKey())
                return -1;
            else if(a.getKey() < b.getKey())
                return 1;
            else
                return a.getValue() > b.getValue() ? -1 : 1;
        });
        int rows = mat.length, i; n = rows;
        for(i = 0; i < rows; i++) {
            int count = binarySearch(mat[i]);
            count = count == -1 ? 0 : count ;
            if(pq.size() < k)
                pq.add(new Pair<>(count, i));
            else {
                if(pq.peek().getKey() > count) {
                    pq.poll();
                    pq.add(new Pair<>(count, i));
                }
            }
        }
        int[] res = new int[k];
        i = k-1;
        while(!pq.isEmpty())
            res[i--] = pq.poll().getValue();
        return res;
    }

    public static void main(String[] args) {
        KWeakest abc = new KWeakest();
        System.out.println(Arrays.toString(abc.kWeakestRows(new int[][]
               {{1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}}, 3)));
    }
}
