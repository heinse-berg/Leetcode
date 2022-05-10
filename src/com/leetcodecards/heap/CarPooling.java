package com.leetcodecards.heap;

import java.util.*;

public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> trips[a][2]));
        int n = trips.length;
        Arrays.sort(trips, Comparator.comparingInt(a -> a[1]));

        for(int i = 0; i < n; i++) {
            while(!pq.isEmpty() && trips[pq.peek()][2] <= trips[i][1]) {
                capacity += trips[pq.poll()][0];
            }
            pq.offer(i);
            capacity -= trips[i][0];
            if(capacity < 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
