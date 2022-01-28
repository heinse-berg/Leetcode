package com.leetcode.contest;

import java.util.*;

public class P_2101 {

    HashMap<Integer, HashSet<Integer>> graph;
    BitSet bitSet;

    public int dfs(int from) {
        int count  = 1;
        bitSet.set(from);
        HashSet<Integer> set = graph.get(from);
        if(set != null) {
            for (int destination : set) {
                if(!bitSet.get(destination))
                    count += dfs(destination);
            }
        }
        return count;
    }

    public int maximumDetonation(int[][] bombs) {
        graph = new HashMap<>();
        int n = bombs.length, max = 1;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                double distance = Math.sqrt(Math.pow(bombs[i][0]-bombs[j][0], 2) + Math.pow(bombs[i][1]-bombs[j][1], 2));
                if(bombs[i][2] >= distance) {
                    if(!graph.containsKey(i))
                        graph.put(i, new HashSet<>());
                    graph.get(i).add(j);
                }
                if(bombs[j][2] >= distance) {
                    if(!graph.containsKey(j))
                        graph.put(j, new HashSet<>());
                    graph.get(j).add(i);
                }
            }
        }
        for(Integer i : graph.keySet()) {
            bitSet = new BitSet(n);
            max = Math.max(dfs(i), max);
        }
        return max;
    }

    public static void main(String[] args) {
        P_2101 abc = new P_2101();
        System.out.println(abc.maximumDetonation(new int[][]
                {{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}}));
        System.out.println(abc.maximumDetonation(new int[][]
                {{54,95,4},{99,46,3},{29,21,3},{96,72,8},{49,43,3},{11,20,3},{2,57,1},{69,51,7},{97,1,10},{85,45,2},{38,47,1},{83,75,3},{65,59,3},{33,4,1},{32,10,2},{20,97,8},{35,37,3}}));
        System.out.println(abc.maximumDetonation(new int[][]
                {{2,1,3},{6,1,4}}));
    }
}
