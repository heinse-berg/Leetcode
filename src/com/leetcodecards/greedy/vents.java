package com.leetcodecards.greedy;

import java.util.*;

public class vents {

    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int ans = 1, n = events.length;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(events[0][0]);

        for(int i = 1; i < n; i++) {
            if(set.last() < events[i][1]) {
                for(int j = events[i][0]; j <= events[i][1]; j++) {
                    if(!set.contains(j)) {
                        set.add(j);
                        ans++;
                        break;
                    }
                }
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        vents abc = new vents();
        System.out.println(abc.maxEvents(new int[][] {{1,2},{1,2},{1,5},{1,5},{3,3}}));
    }
}
