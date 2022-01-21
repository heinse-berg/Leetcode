package com.leetcodecards.hashing;

import java.util.function.Function;

class Entry {
    Entry next;
    Integer val;

    public Entry() {
        val = null;
        next = null;
    }

    public Entry(int val) {
        this.val = val;
        next = null;
    }
}

public class MyHashSet {
    Entry[] entries;
    private static Function<Integer, Integer> HASH_FUNCTION = a -> a % 1000000;

    public MyHashSet() {
        this.entries = new Entry[1000000];
        for(int i = 0; i < 1000000; i++)
            entries[i] = new Entry();
    }

    public void add(int num) {
        int hash = HASH_FUNCTION.apply(num);
        if(entries[hash].val == null) {
            entries[hash].val = num;
        }
        else {
            Entry curr = entries[hash];
            while(curr.next != null)
                curr = curr.next;
            curr.next = new Entry(num);
        }
    }

    public void remove(int num) {
        int hash = HASH_FUNCTION.apply(num);
        Entry curr = entries[hash];
        if(curr.val == null) {
            return;
        }
        if(curr.val == num) {
            if(curr.next != null)
                entries[hash] = curr.next;
            else
                curr.val = null;
            return;
        }
        else {
            boolean flag = false;
            while(curr.next != null) {
                if(curr.next.val == num) {
                    flag = true;
                    break;
                }
                curr = curr.next;
            }
            if(!flag) {
                return;
            }
        }
        if(curr.next.next != null)
            curr.next = curr.next.next;
        else
            curr.next = null;
    }

    public boolean contains(int num) {
        int hash = HASH_FUNCTION.apply(num);
        Entry curr = entries[hash];
        if(curr.val == null) {
            return false;
        }
        if(curr.val == num)
            return true;
        else {
            while(curr != null) {
                if(curr.val == num)
                    return true;
                curr = curr.next;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        MyHashSet abc = new MyHashSet();
        Integer i1 = 2;
        abc.add(1);
        abc.add(2);
        System.out.println(abc.contains(1));
        System.out.println(abc.contains(3));
        abc.add(2);
        System.out.println(abc.contains(2));
        abc.remove(2);
        System.out.println(abc.contains(2));
        System.out.println();
    }
}
/*
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
 */
