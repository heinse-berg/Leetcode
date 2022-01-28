package com.leetcodecards.graph.kruskal;

import java.util.*;

class Edge {
    public int distance;
    public int v1;
    public int v2;

    public Edge(int distance, int v1, int v2) {
        this.distance = distance;
        this.v1 = v1;
        this.v2 = v2;
    }

}

class UnionFind {
    private int[] root;
    private int[] rank;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

public class MinCost {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length, cost = 0, i, j, distance, count = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.distance));
        UnionFind uf = new UnionFind(n);

        for(i = 0; i < n; i++)
            for(j = i+1; j < n; j++) {
                distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                pq.add(new Edge(distance, i, j));
            }

        while(count != n-1) {
            Edge e = pq.poll();
            if(!(uf.connected(e.v1, e.v2))) {
                uf.union(e.v1, e.v2);
                count++;
                cost += e.distance;
            }
        }

        return cost;
    }

    public static void main(String[] args) {
        MinCost abc = new MinCost();
        System.out.println();
    }
}
