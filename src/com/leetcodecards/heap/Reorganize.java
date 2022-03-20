package com.leetcodecards.heap;

import javafx.util.Pair;

import java.util.*;

public class Reorganize {

    public String reorganizeString(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a.getValue()));
        int n = s.length();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) > (n+1)/2)
                return "";
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet())
            pq.add(new Pair<>(entry.getKey(), entry.getValue()));

        while(pq.size() > 1) {
            Pair<Character, Integer> pair1 = pq.poll();
            Pair<Character, Integer> pair2 = pq.poll();
            sb.append(pair1.getKey());
            sb.append(pair2.getKey());
            if(pair1.getValue() > 1)
                pq.add(new Pair<>(pair1.getKey(), pair1.getValue()-1));
            if(pair2.getValue() > 1)
                pq.add(new Pair<>(pair2.getKey(), pair2.getValue()-1));
        }

        if(!pq.isEmpty())
            sb.append(pq.poll().getKey());

        return sb.toString();
    }

    public static void main(String[] args) {
        Reorganize abc = new Reorganize();
        System.out.println(abc.reorganizeString("aab"));
    }
}
