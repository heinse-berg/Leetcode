package com.leetcodecards.heap;

import javafx.util.Pair;

import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSorted {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        ListNode ans = null, curr = null, temp, prev = null;
        int k = lists.length, i;

        for(i = 0; i < k; i++) {
            if(lists[i] != null)
                pq.add(lists[i]);
        }

        if(!pq.isEmpty()) {
            ans = new ListNode();
            curr = ans;
            while(!pq.isEmpty()) {

                temp = pq.poll();
                ans.val = temp.val;

                ans.next = new ListNode();
                prev = ans;
                ans = ans.next;

                if(temp.next != null)
                    pq.add(temp.next);
            }
        }

        if(prev != null)  prev.next = null;
        return curr;
    }

    public static void main(String[] args) {
        MergeKSorted abc = new MergeKSorted();
        ListNode l = new ListNode(0);
        l.next = new ListNode(2);
        l.next.next = new ListNode(5);
        System.out.println(abc.mergeKLists(new ListNode[]{l}));
    }
}
