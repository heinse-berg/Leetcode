package com.leetcodecards.graph.disjoint.set;

import java.util.*;

public class Computers {

    int[] root;
    int[] rank;

    public void init(int n) {
        for(int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int findRoot(int x) {
        if(x == root[x])
            return x;
        return root[x] = findRoot(root[x]);
    }

    public void union(int x, int y) {
        int rootX = findRoot(x);
        int rootY = findRoot(y);

        if(rootX == rootY)
            return;
        if(rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        }
        else if(rank[rootX] < rank[rootY]){
            root[rootX] = root[rootY];
        }
        else {
            root[rootY] = root[rootX];
            rank[rootX] += 1;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        root = new int[n];
        rank = new int[n];
        init(n);

        if(connections.length < n-1)
            return -1;

        for(int[] connection : connections) {
            union(connection[0], connection[1]);
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int root = findRoot(i);
            if(!map.containsKey(root))
                map.put(root, 0);
            map.put(root, map.get(root) + 1);
        }


        return map.keySet().size() - 1;
    }

    public static void main(String[] args) {
        Computers abc = new Computers();
        System.out.println(abc.makeConnected(100, new int[][]
        {{17,51},{33,83},{53,62},{25,34},{35,90},{29,41},{14,53},{40,84},{41,64},{13,68},{44,85},{57,58},{50,74},{20,69},{15,62},{25,88},{4,56},{37,39},{30,62},{69,79},{33,85},{24,83},{35,77},{2,73},{6,28},{46,98},{11,82},{29,72},{67,71},{12,49},{42,56},{56,65},{40,70},{24,64},{29,51},{20,27},{45,88},{58,92},{60,99},{33,46},{19,69},{33,89},{54,82},{16,50},{35,73},{19,45},{19,72},{1,79},{27,80},{22,41},{52,61},{50,85},{27,45},{4,84},{11,96},{0,99},{29,94},{9,19},{66,99},{20,39},{16,85},{12,27},{16,67},{61,80},{67,83},{16,17},{24,27},{16,25},{41,79},{51,95},{46,47},{27,51},{31,44},{0,69},{61,63},{33,95},{17,88},{70,87},{40,42},{21,42},{67,77},{33,65},{3,25},{39,83},{34,40},{15,79},{30,90},{58,95},{45,56},{37,48},{24,91},{31,93},{83,90},{17,86},{61,65},{15,48},{34,56},{12,26},{39,98},{1,48},{21,76},{72,96},{30,69},{46,80},{6,29},{29,81},{22,77},{85,90},{79,83},{6,26},{33,57},{3,65},{63,84},{77,94},{26,90},{64,77},{0,3},{27,97},{66,89},{18,77},{27,43}}));
    }
}
