package com.leetcode;

import java.util.*;

public class P_56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> l = new LinkedList<>(Arrays.asList(intervals));
        l.sort(Comparator.comparingInt(a -> a[0]));
        int n = l.size();
        for(int i = 0; i < n - 1; ) {
            int start2 = l.get(i+1)[0]; int end2 = l.get(i+1)[1];
            int end1 = l.get(i)[1];
            if(start2 <= end1) {
                l.get(i)[1] = Math.max(end1, end2);
                l.remove(i + 1);
                n--;
            }
            else i++;
        }
        return l.toArray(new int[n][2]);
    }

    public static void main(String[] args) {
        //enter code
        /*
        [1,3],[2,6],[8,10],[15,18]
         */
        System.out.println(Arrays.deepToString(new P_56().merge(new int[][]
                {{1,3},{2,6},{8,10},{15,18}} )));
    }
}
