package com.leetcodecards.heap;

import java.util.*;

class MedianFinder {

    PriorityQueue<Integer> maxHeapLo = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeapHigh = new PriorityQueue<>();

    public MedianFinder() {
    }

    public void addNum(int num) {
        maxHeapLo.add(num);
        minHeapHigh.add(maxHeapLo.poll());
        if(minHeapHigh.size() > maxHeapLo.size())
            maxHeapLo.add(minHeapHigh.poll());
    }

    public double findMedian() {
        return maxHeapLo.size() == minHeapHigh.size() ? ((double) (maxHeapLo.peek() + minHeapHigh.peek())) / 2 :
                maxHeapLo.peek();
    }

    public static void main(String[] args) {
        MedianFinder abc = new MedianFinder();
        System.out.println();
    }
}
