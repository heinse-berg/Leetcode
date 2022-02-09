package com.leetcodecards.graph.disjoint.set;

import java.util.*;

public class LockKey {
    LinkedList<HashSet<Integer>>  graph = new LinkedList<>();
    HashSet<Integer> visited = new HashSet<>();
    List<List<Integer>> rooms;

    public void dfs(int src) {
        visited.add(src);
        for(int dest : rooms.get(src)) {
            if(!visited.contains(dest)) {
                dfs(dest);
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.rooms = rooms;
        int i = 0;
        for(; i< rooms.size(); i++)
            graph.addLast(new HashSet<>());

        i = 0;
        for(List<Integer> l : rooms) {
            for(int k : l) {
                graph.get(i).add(k);
            }
            i++;
        }

        dfs(0);

        return visited.size() == rooms.size();
    }

    public static void main(String[] args) {
        LockKey abc = new LockKey();
        List<List<Integer>> l = new ArrayList<>();
        l.add((new ArrayList<>(Arrays.asList(1))));
        l.add((new ArrayList<>()));
        l.add((new ArrayList<>(Arrays.asList(0,3))));
        l.add((new ArrayList<>(Arrays.asList(1))));
        System.out.println(abc.canVisitAllRooms(l));
    }
}
