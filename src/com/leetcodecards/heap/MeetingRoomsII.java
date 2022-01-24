package com.leetcodecards.heap;

import java.util.*;

public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int i, len = intervals.length, currentRoomsOccupied = 1, earliestToGetOver;
        heap.add(intervals[0][1]);
        for(i = 1; i < len; i++) {
            earliestToGetOver = heap.peek();
            if(intervals[i][0] < earliestToGetOver) {
                currentRoomsOccupied++;
            }
            else {
                heap.poll();
            }
            heap.add(intervals[i][1]);
        }
        return currentRoomsOccupied;
    }

    public static void main(String[] args) {
        MeetingRoomsII abc = new MeetingRoomsII();
        System.out.println(abc.minMeetingRooms(new int[][]
                {{0,30},{5,10},{15,20}}));
    }
}
//[0,30],[5,10],[15,20]
