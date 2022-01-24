package com.leetcodecards.graph.disjoint.set;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class NoOfProvinces {
    int[] root;
    int[] rank;

    public void init(int n) {
        int i;
        root = new int[n];
        rank = new int[n];
        for(i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int findRoot(int x) {
        if(root[x] == x)
            return x;
        root[x] = findRoot(root[x]);
        return root[x];
    }

    public void connectNodes(int x, int y) {
        int rootX = findRoot(x);
        int rootY = findRoot(y);
        if(rootX != rootY) {
            if(rank[rootX] > rank[rootY])
                root[rootY] = rootX;
            else if(rank[rootX] < rank[rootY])
                root[rootX] = rootY;
            else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, i, j;
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(isConnected, Comparator.comparingInt(a -> a[0]));
        init(n);
        for(i = 0; i < n; i++) {
            for(j = 0; j < n; j++) {
                if(isConnected[i][j] == 1)
                    connectNodes(i, j);
            }
        }

        for(int num : root) {
            set.add(num);
        }
        return set.size();
    }

    public static void main(String[] args) {
        NoOfProvinces abc = new NoOfProvinces();
        System.out.println(abc.findCircleNum(new int[][]
                       {{1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
                        {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},
                        {0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},
                        {0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},
                        {0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},
                        {1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                        {0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},
                        {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
                        {0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},
                        {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},
                        {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}}));
    }
}
