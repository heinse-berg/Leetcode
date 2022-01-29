package com.leetcode;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;

public class P_149 {

    public int maxPoints(int[][] points) {
        HashMap<Pair<Double, Double>, HashSet<Pair<Integer, Integer>>> map = new HashMap<>();
        double slope, yIntercept;
        int n = points.length, max = 0;

        if(n == 1)
            return 1;

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(points[i][0] - points[j][0] == 0) {
                    slope = Double.MIN_VALUE;
                    yIntercept = points[i][0];
                }
                else {
                    slope = ((double) (points[i][1] - points[j][1])) / ((double) (points[i][0] - points[j][0]));
                    yIntercept = points[i][1] - (slope * points[i][0]);
                }
                Pair<Double, Double> pair = new Pair<>(slope, yIntercept);
                if(!map.containsKey(pair)) {
                    HashSet<Pair<Integer, Integer>> set = new HashSet<>();
                    set.add(new Pair<>(points[i][0], points[i][1]));
                    set.add(new Pair<>(points[j][0], points[j][1]));
                    map.put(pair, set);
                }
                else {
                    map.get(pair).add(new Pair<>(points[i][0], points[i][1]));
                    map.get(pair).add(new Pair<>(points[j][0], points[j][1]));
                }
            }
        }

        for(HashSet set : map.values()) {
            max = Math.max(set.size(), max);
        }
        return max;
    }

    public static void main(String[] args) {
        P_149 abc = new P_149();
        System.out.println();
    }
}
