package com.playground;

import java.util.*;

public class TryOut1 {

    public static void main(String[] args) {
        TryOut1 abc = new TryOut1();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 9;
        while(i >= 0) {
            pq.add(i);
            if(pq.size() > 3)
                pq.poll();
            //System.out.println(pq);
            i--;
        }
        pq.add(100);pq.add(200);
        //System.out.println(pq);
        pq.poll();
        //System.out.println(pq);
        pq.poll();
        //System.out.println(pq);
        //System.out.println(pq);

        HashSet<Integer> set = new HashSet<>();
        Iterator<Integer> iterator = set.iterator();
        iterator.hasNext();HashMap<Character, Integer> map = new HashMap<>();
        map.merge('c', 1, Integer::sum);
        System.out.println(-8%5);
        Integer a = 5;
        Integer b = 5;
        System.out.println(a.equals(b));
        System.out.println(a.equals(b));
        //ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> m = new HashMap<>();
        m.put(new Integer(0), 1);
        m.put(new Integer(0), 1);
        System.out.println();

        TreeSet<Integer> s = new TreeSet<>();
    }
}
