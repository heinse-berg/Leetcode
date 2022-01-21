package com.leetcodecards.bin.binsearchtree;

import java.util.*;

public class KthLargest {
    final PriorityQueue<Integer> q;
    final int k;

    public KthLargest(int k, int[] a) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int n : a)
            add(n);
    }

    public int add(int n) {
        if (q.size() < k)
            q.offer(n);
        else if (q.peek() < n) {
            q.poll();
            q.offer(n);
        }
        return q.peek();
    }

    public static void main(String[] args) {
        KthLargest abc = new KthLargest(3, new int[] {5,6,7});
        abc.add(0);
        abc.add(10);
        System.out.println();
    }
}
