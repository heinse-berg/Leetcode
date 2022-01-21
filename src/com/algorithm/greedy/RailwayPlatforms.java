package com.algorithm.greedy;

import java.util.ArrayList;

class Pair {
    int time;
    boolean isArrival;

    Pair(int time, boolean isArrival) {
        this.isArrival = isArrival;
        this.time = time;
    }
}

public class RailwayPlatforms {

    static int maxPlatforms(int[] arr, int[] dep) {
        int n = arr.length, i, ans = 0, temp = 0;
        ArrayList<Pair> timings = new ArrayList<>();
        for(i = 0; i < n; i++) {
            timings.add(new Pair(arr[i], true));
            timings.add(new Pair(dep[i], false));
        }
        timings.sort((a, b) -> {
            if (a.time == b.time) {
                if ((a.isArrival && b.isArrival) || !(a.isArrival || b.isArrival))
                    return 0;
                else if (a.isArrival)
                    return -1;
                return 1;
            }
            return a.time - b.time;
        });
        for(Pair pair : timings) {
            if(pair.isArrival)
                temp++;
            else
                temp--;
            ans = Math.max(ans, temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 900, 940, 950, 1100, 1500, 1800 };
        int[] dep = new int[] { 910, 1200, 1120, 1130, 1900, 2000 };
        System.out.println(maxPlatforms(arr, dep));
    }
}
