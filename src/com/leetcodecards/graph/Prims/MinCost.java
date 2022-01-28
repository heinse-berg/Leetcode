package com.leetcodecards.graph.Prims;

import java.util.Comparator;
import java.util.PriorityQueue;

class Edge {
    public int distance;
    public int v1;
    public int v2;

    public Edge(int v1, int v2, int distance) {
        this.distance = distance;
        this.v1 = v1;
        this.v2 = v2;
    }

}

public class MinCost {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length, cost = 0, j, distance, count = 1;
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.distance));
        boolean[] visited = new boolean[n];

        for(j = 1; j < n; j++) {
            distance = Math.abs(points[0][0] - points[j][0]) + Math.abs(points[0][1] - points[j][1]);
            Edge edge = new Edge(0, j, distance);
            pq.add(edge);
        }
        visited[0] = true;

        while(!pq.isEmpty() && count < n) {
            while(visited[pq.peek().v2]) {
                pq.poll();
            }
            Edge currEdge = pq.poll();
            int v2 = currEdge.v2;
            visited[v2] = true;
            cost += currEdge.distance;
            count++;

            for(j = 0; j < n; j++) {
                if(!visited[j]) {
                    distance = Math.abs(points[v2][0] - points[j][0]) + Math.abs(points[v2][1] - points[j][1]);
                    pq.add(new Edge(v2, j, distance));
                }
            }
        }

        return cost;
    }

    public static void main(String[] args) {
        MinCost abc = new MinCost();
        System.out.println(abc.minCostConnectPoints(new int[][]{{0,0}, {2,2}, {3,10}, {5,2}, {7,0}}));
        //[[0,0],[2,2],[3,10],[5,2],[7,0]]
    }
}
