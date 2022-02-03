package com.leetcodecards.graph.djikstra;

import javafx.util.Pair;

import java.util.*;

public class DijkstraAdjacency {

    /*static class Edge {
        int vertex;
        int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }*/

    public int shortestPath(int n, int[][] grph, int source, int destination) {

        HashMap<Integer, HashSet<Pair<Integer, Integer>>> graph = new HashMap<>();
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
        int[] distance = new int[n];

        for(int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
            distance[i] = Integer.MAX_VALUE;
        }

        for(int[] d : grph) {
            graph.get(d[0]).add(new Pair<>(d[1], d[2]));
            graph.get(d[1]).add(new Pair<>(d[0], d[2]));
        }

        pq.add(new Pair<>(source, 0));
        distance[source] = 0;
        while(!pq.isEmpty()) {
            Pair<Integer, Integer> curr = pq.poll();
            int currSource = curr.getKey();
            int dist = curr.getValue();

            if(graph.containsKey(currSource)) {
                for (Pair<Integer, Integer> neighbor : graph.get(currSource)){
                    int dest = neighbor.getKey();
                    int cost = neighbor.getValue();
                    if(distance[dest] > dist + cost) {
                        distance[dest] = dist + cost;
                        pq.add(new Pair<>(dest, distance[dest]));
                    }
                }
            }
        }

        System.out.println(Arrays.toString(distance));
        return distance[destination];
    }

    public static void main(String[] args) {
        DijkstraAdjacency abc = new DijkstraAdjacency();
        System.out.println(abc.shortestPath(5, new int[][] {
                {0, 1, 10}, {0, 2, 1}, {2, 1, 2}, {1, 3, 20}, {2, 3, 3}
        }, 0, 3));

    }
}
