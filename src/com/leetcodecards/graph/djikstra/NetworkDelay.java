package com.leetcodecards.graph.djikstra;

import javafx.util.Pair;

import java.util.*;

public class NetworkDelay {

    public int networkDelayTime(int[][] times, int n, int k) {

        HashMap<Integer, HashSet<Pair<Integer, Integer>>> graph = new HashMap<>();
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
        int[] distance = new int[n+1];
        int i, max = Integer.MIN_VALUE;

        for(i = 0; i < n+1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for(int[] edge : times) {
            if(!graph.containsKey(edge[0]))
                graph.put(edge[0], new HashSet<>());
            graph.get(edge[0]).add(new Pair<>(edge[1], edge[2]));
        }

        if(!graph.containsKey(k))
            return -1;

        distance[k] = 0;
        pq.add(new Pair<>(k, 0));

        while(!pq.isEmpty()) {
            Pair<Integer, Integer> current = pq.poll();
            int vertex = current.getKey();
            int dist = current.getValue();

            if(graph.containsKey(vertex)) {
                for(Pair<Integer, Integer> pair : graph.get(vertex)) {
                    int toVertex = pair.getKey();
                    int toDistance = pair.getValue();

                    if(distance[toVertex] > dist + toDistance) {
                        distance[toVertex] = dist + toDistance;
                        pq.add(pair);
                    }
                }
            }
        }

        for(i = 1; i < n+1; i++) {
            if(distance[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(distance[i], max);
        }

        return max;
    }

    public static void main(String[] args) {
        NetworkDelay abc = new NetworkDelay();
        System.out.println(abc.networkDelayTime(new int[][] {{2,1,1},{2,3,1},{3,4,1}}, 4, 2));
        //[[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
    }
}
