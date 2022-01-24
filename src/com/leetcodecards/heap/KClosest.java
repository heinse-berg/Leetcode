package com.leetcodecards.heap;

import javafx.util.Pair;

import java.util.*;

public class KClosest {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Double,Integer>> heap = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingDouble(a -> a.getKey())));
        double distance;
        int i, len = points.length;
        for(i = 0; i < len; i++) {
            distance = Math.sqrt((points[i][0]*points[i][0]) + (points[i][1]*points[i][1]));
            if(heap.size() < k) {
                heap.add(new Pair<>(distance, i));
            }
            else{
                if(heap.peek().getKey() > distance) {
                    heap.poll();
                    heap.add(new Pair<>(distance, i));
                }
            }
        }
        int[][] ans = new int[k][2];
        i = 0;
        while(!heap.isEmpty())
            ans[i] = points[heap.poll().getValue()];
        return ans;
    }

    public static void main(String[] args) {
        KClosest abc = new KClosest();
        System.out.println(Arrays.deepToString(abc.kClosest(new int[][]{{3,3},{5,-1},{-2,4}}, 2)));
    }
}
//[[3,3],[5,-1],[-2,4]]
//2

