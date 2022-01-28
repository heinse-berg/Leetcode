package com.leetcodecards.graph.bfs;

import java.util.*;
/*
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 */
public class AllPaths {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int i, n = graph.length, j;
        ArrayList<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, HashSet<Integer>> adjacencyList = new HashMap<>();
        ArrayDeque<LinkedList<Integer>> queue = new ArrayDeque<>();
        LinkedList<Integer> path = new LinkedList<>();

        for(i = 0; i < n; i++) {
            for (j = 0; j < graph[i].length; j++) {
                if (!adjacencyList.containsKey(i))
                    adjacencyList.put(i, new HashSet<>());
                adjacencyList.get(i).add(graph[i][j]);
            }
        }
        path.add(0);
        queue.addLast(path);

        while(!queue.isEmpty()) {
            LinkedList<Integer> currPath = queue.pollFirst();
            if(currPath.getLast() == n-1) {
                res.add(new ArrayList<>(currPath));
            }
            HashSet<Integer> neighbours = adjacencyList.get(currPath.getLast());
            if(neighbours != null) {
                for (int neighbour : neighbours) {
                    LinkedList<Integer> tmp = new LinkedList<>(currPath);
                    tmp.add(neighbour);
                    queue.add(tmp);
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        AllPaths abc = new AllPaths();
        System.out.println();
        System.out.println(abc.allPathsSourceTarget(new int[][] {{4,3,1},{3,2,4},{3},{4},{}}));
    }
}
