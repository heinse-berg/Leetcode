package com.leetcodecards.graph.bfs;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class AlternateColors {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        ArrayDeque<Pair<Integer, Integer>> redQueue = new ArrayDeque<>(), blueQueue = new ArrayDeque<>();
        HashMap<Integer, HashSet<Integer>> redGraph = new HashMap<>(), blueGraph = new HashMap<>(), redQueueGraph = blueGraph, blueQueueGraph = redGraph;
        int depth = 0;
        HashSet<Integer> visited = new HashSet<>();
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);

        for(int i = 0; i < n; i++) {
            redGraph.put(i, new HashSet<>());
            blueGraph.put(i, new HashSet<>());
        }

        for(int[] edge : redEdges)
            if(edge[0] != edge[1])
                redGraph.get(edge[0]).add(edge[1]);

        for(int[] edge : blueEdges)
            if(edge[0] != edge[1])
                blueGraph.get(edge[0]).add(edge[1]);

        for(int i : redGraph.get(0))
            redQueue.addLast(new Pair<>(0, i));
        for(int i : blueGraph.get(0))
            blueQueue.addLast(new Pair<>(0, i));

        while(visited.size() < n && (!blueQueue.isEmpty() || !redQueue.isEmpty())) {
            depth++;

            int redLength = redQueue.size();
            for(int i = 0; i < redLength; i++) {
                int currentVertex = redQueue.peekFirst().getValue();
                if(ans[currentVertex] > depth) {
                    ans[currentVertex] = depth;
                    visited.add(currentVertex);
                }
                blueQueueGraph.get(redQueue.pollFirst().getKey()).remove(currentVertex);
                for(int j : redQueueGraph.get(currentVertex)) {
                    redQueue.addLast(new Pair<>(currentVertex, j));
                }
            }

            int blueLength = blueQueue.size();
            for(int i = 0; i < blueLength; i++) {
                int currentVertex = blueQueue.peekFirst().getValue();
                if(ans[currentVertex] > depth) {
                    ans[currentVertex] = depth;
                    visited.add(currentVertex);
                }
                redQueueGraph.get(blueQueue.pollFirst().getKey()).remove(currentVertex);
                for(int j : blueQueueGraph.get(currentVertex)) {
                    blueQueue.addLast(new Pair<>(currentVertex, j));
                }
            }
            HashMap<Integer, HashSet<Integer>> temp = redQueueGraph;
            redQueueGraph = blueQueueGraph;
            blueQueueGraph = temp;

        }

        for(int i = 1; i < ans.length; i++)
            if(ans[i] == Integer.MAX_VALUE)
                ans[i] = -1;

        ans[0] = 0;
        return ans;

    }

    public static void main(String[] args) {
        AlternateColors ac = new AlternateColors();
        //5
        //[[2,0],[4,3],[4,4],[3,0],[1,4]]
        //[[2,1],[4,3],[3,1],[3,0],[1,1],[2,0],[0,3],[3,3],[2,3]]
        System.out.println(Arrays.toString(ac.shortestAlternatingPaths(5, new int[][] {{2,0},{4,3},{4,4},{3,0},{1,4}},
                new int[][] {{2,1},{4,3},{3,1},{3,0},{1,1},{2,0},{0,3},{3,3},{2,3}})));
    }

}
