package com.leetcodecards.graph.disjoint.set;

import javafx.util.Pair;

import java.util.*;

public class SwapString {
    int[] root;
    int[] rank;

    public void init(int n) {
        root = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int findRoot(int x) {
        if(x == root[x])
            return x;
        return root[x] = findRoot(root[x]);
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

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int i, len = s.length();
        char c;
        HashMap<Integer, Pair<PriorityQueue<Character>, PriorityQueue<Integer>>> map = new HashMap<>();

        init(len);
        for(i = 0; i < pairs.size(); i++)
            connectNodes((pairs.get(i).get(0)), (pairs.get(i).get(1)));

        for(i = 0; i < len; i++) {
            int root = findRoot(i);
            c = s.charAt(i);

            if(!map.containsKey(root))
                map.put(root, new Pair<>(new PriorityQueue<>(), new PriorityQueue<>()));
            map.get(root).getKey().add(c);
            map.get(root).getValue().add(i);
        }

        StringBuilder sb = new StringBuilder(s);

        for(Pair<PriorityQueue<Character>, PriorityQueue<Integer>> pair : map.values()) {
            if(pair.getValue().size() > 1) {
                PriorityQueue<Character> ic = pair.getKey();
                PriorityQueue<Integer> ii = pair.getValue();

                while(!ic.isEmpty())
                    sb.setCharAt(ii.poll(), ic.poll());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        SwapString abc = new SwapString();
        ArrayList<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(5,3)); list.add(Arrays.asList(3,0)); list.add(Arrays.asList(5,1)); list.add(Arrays.asList(1,1)); list.add(Arrays.asList(1,5)); list.add(Arrays.asList(3,0));
        list.add(Arrays.asList(0,2));
        System.out.println(abc.smallestStringWithSwaps("pwqlmqm", list));
        /*
        "pwqlmqm"
[[5,3],[3,0],[5,1],[1,1],[1,5],[3,0],[0,2]]
         */
    }
}
