package com.leetcodecards.graph.djikstra;

import javafx.util.Pair;

import java.util.*;

public class GFG {

    int[][] graph;
    int[] distance;
    int[] parent;
    boolean[] visited;
    int n;

    public void init(int[] distance, int[] parent) {
        for(int i = 1; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }
    }

    public void djikstra(int[][] graph) {

        int n = graph.length, i, j;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        this.graph = graph;
        this.n = n;
        visited = new boolean[n];
        distance = new int[9]; parent = new int[9];

        init(distance, parent);
        parent[0] = 0;
        pq.add(new Pair<>(0, 0));
        for(i = 0; i < n; i ++) {
            if (graph[0][i] != 0) {
                distance[i] = graph[0][i];
                pq.add(new Pair<>(graph[0][i], i));
                parent[i] = 0;
            }
        }
        visited[0] = true;

        while(!pq.isEmpty()) {
            Pair<Integer, Integer> current = pq.poll();
            int vertex = current.getValue();

            if(!visited[vertex]) {
                int dist = current.getKey();
                for(j = 0; j < n; j++) {
                    if(graph[vertex][j] != 0 && !visited[j] && (distance[j] > dist + graph[vertex][j])) {
                        distance[j] = dist + graph[vertex][j];
                        parent[j] = vertex;
                        pq.add(new Pair<>(distance[j], j));
                    }
                }
                visited[vertex] = true;
            }

        }

    }

    public List<Integer> getPath(int destination) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(destination);
        while(parent[destination] != destination) {
            destination = parent[destination];
            list.add(destination);
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        GFG abc = new GFG();

        int[][] graph = new int[][] {
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        abc.djikstra(graph);
        System.out.println(Arrays.toString(abc.distance));
        System.out.println(Arrays.toString(abc.parent));
        for( int i = 0; i < 9 ; i++)
            System.out.printf("Path to Source %d -> %s%n", i, abc.getPath(i));

    }
}
