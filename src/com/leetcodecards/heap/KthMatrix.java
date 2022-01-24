package com.leetcodecards.heap;

import javafx.util.Pair;

import java.util.*;

public class KthMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        int i, n = matrix.length, j = 0;
        for(i = 0; i < Math.min(n, k); i++) {
            pq.add(new Pair<>(matrix[i][0], new Pair<>(i, 0)));
        }
        Pair<Integer, Pair<Integer, Integer>> element = pq.peek();
        while(k-- > 0) {
            element = pq.poll();
            i = element.getValue().getKey(); j = element.getValue().getValue()+1;
            if(j < n)
                pq.add(new Pair<>(matrix[i][j], new Pair<>(i, j)));
        }
        return element.getKey();
    }

    public static void main(String[] args) {
        KthMatrix abc = new KthMatrix();
        System.out.println(abc.kthSmallest(new int[][]
                {{1,5,9},{10,11,13},{12,13,15}}, 8));
    }
}
