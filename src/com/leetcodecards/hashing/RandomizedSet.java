package com.leetcodecards.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
    ArrayList<Integer> list = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    Random random = new Random();

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) return false;

        map.put(val, list.size());
        list.add(val);

        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int index = map.get(val);
        map.put(list.get(list.size()-1), index);
        list.set(index, list.get(list.size()-1));
        list.remove(list.size()-1);
        map.remove(val);
        random.nextInt(34);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

}
