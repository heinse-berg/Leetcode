package com.playground;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MergeOverlapping {

    public int[][] merge(int[][] intervals) {

        LinkedList<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for(int[] a : intervals) {
            if(res.isEmpty() || res.getLast()[1] < a[0])
                res.add(a);
            else
                res.getLast()[1] = Math.max(res.getLast()[1], a[1]);
        }

        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        MergeOverlapping abc = new MergeOverlapping();
        System.out.println(Arrays.deepToString(abc.merge(new int[][]{{1, 3}, {15, 18}, {2, 6}, {8, 10}})));
        //[[1,6],[8,10],[15,18]]
    }
}
