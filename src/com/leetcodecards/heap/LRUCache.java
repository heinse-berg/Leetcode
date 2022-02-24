package com.leetcodecards.heap;

import java.util.*;

public class LRUCache {

    LinkedHashMap<Integer, Integer> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return this.size() > capacity;
            }
        };
    }

    public int get(int key) {
        Integer k = map.get(key);
        return k == null ? -1 : k;
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache abc = new LRUCache(2);
        abc.put(1,1);
        abc.put(2,2);

        System.out.println();
    }
}
