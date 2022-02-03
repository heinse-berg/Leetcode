package com.leetcodecards.graph.djikstra;

import java.util.*;

public class FlightKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] graph = new int[n][n];
        int[] distance = new int[n];
        int[] currStops = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        for(int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }


        for(int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
            currStops[i] = Integer.MAX_VALUE;
        }

        distance[src] = 0; currStops[src] = 0;
        pq.add(new int[] {src, 0, 0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int vertex = curr[0]; int stops = curr[2]; int cost = curr[1];

            if(dst == vertex)
                break;

            if(!(stops == k+1)) {
                for (int j = 0; j < n; j++) {
                    if( graph[vertex][j] != 0 )  {

                        if(distance[j] > graph[vertex][j] + cost) {
                            distance[j] = graph[vertex][j] + cost;
                            pq.add(new int[] {j, distance[j], stops+1});
                        }

                        else if(stops < currStops[j]) {
                            pq.add(new int[] {j,  graph[vertex][j] + cost, stops+1});
                        }

                        currStops[j] = stops;
                    }
                }
            }
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }

    public static void main(String[] args) {
        FlightKStops abc = new FlightKStops();
        System.out.println(abc.findCheapestPrice(6, new int[][]
                {{0,1,5},{0,3,2},{3,1,2},{1,4,1},{4,2,3},{4,5,1},{5,2,1}}, 0,2,2));
        //5
        //[[0,1,5],[1,2,5],[0,3,2],[3,1,2],[1,4,1],[4,2,1]]
        //0
        //2
        //2
    }
}
