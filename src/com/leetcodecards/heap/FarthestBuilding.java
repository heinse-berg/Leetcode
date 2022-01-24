package com.leetcodecards.heap;

import java.util.*;

public class FarthestBuilding {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i, n = heights.length, diff;
        for(i = 0; i < n-1; i++) {
            diff = heights[i] - heights[i+1];
            if(diff < 0) {
                diff = -diff;
                if(minHeap.size() < ladders) {
                    minHeap.add(diff);
                }
                else {
                    if(ladders == 0) {
                        bricks -= diff;
                        if(bricks < 0)
                            break;
                    }
                    else if(minHeap.peek() > diff) {
                        if(bricks - diff < 0)
                            break;
                        bricks -= diff;
                    }
                    else {
                        bricks -= minHeap.poll();
                        if(bricks < 0)
                            break;
                        minHeap.add(diff);
                    }
                }
            }
        }
        return i;
    }

    public static void main(String[] args) {
        FarthestBuilding abc = new FarthestBuilding();
        System.out.println(abc.furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19},10,2));
           //[14,3,19,3]
        //17
        //0
    }
}
