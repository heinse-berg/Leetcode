package com.playground;

import javafx.util.Pair;

import java.util.*;

public class KLargest {

    public int[] maxSubsequence(int[] nums, int k) {
        int[] ans  = new int[k];
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        for(int i = 0; i < nums.length; i++) {
            if (minHeap.size() < k)
                minHeap.add(new Pair<>(nums[i], i));
            else {
                if(nums[i] > minHeap.peek().getKey()) {
                    minHeap.poll();
                    minHeap.add(new Pair<>(nums[i], i));
                }
            }
        }
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
        while(!minHeap.isEmpty()) {
            pq.add(minHeap.poll());
        }
        int i = 0;
        while(!pq.isEmpty()) {
            ans[i++] = pq.poll().getKey();
        }
        return ans;
    }

    public static void main(String[] args) {
        KLargest abc = new KLargest();
        System.out.println();
    }
}
