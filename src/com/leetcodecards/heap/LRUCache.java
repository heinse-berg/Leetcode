package com.leetcodecards.heap;

import java.util.*;

public class LRUCache {

    int capacity;
    LinkedList<Integer> list;
    HashMap<Integer, Integer> map;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        list = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {

        if(!map.containsKey(key))
            return -1;

        list.remove((Integer) key);
        list.addFirst(key);
        return map.get(key);
    }

    public void put(int key, int value) {

        if(map.keySet().size() == capacity && !map.containsKey(key)) {
            int keyToEvict = list.getLast();
            map.remove(keyToEvict);
            list.removeLast();
        }

        if(map.containsKey(key))
            list.remove((Integer) key);

        map.put(key, value);
        list.addFirst(key);
    }

    public static void main(String[] args) {
        LRUCache abc = new LRUCache(2);
        abc.put(1,1);
        abc.put(2,2);
        System.out.println(abc.get(1));
        abc.put(3, 3);
        System.out.println(abc.get(2));
        abc.put(4, 4);
        System.out.println(abc.get(1));
        System.out.println(abc.get(3));
        System.out.println(abc.get(4));
        //["LRUCache","put","put","get","put","get","put","get","get","get"]
        //[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]

        System.out.println();
    }
}
