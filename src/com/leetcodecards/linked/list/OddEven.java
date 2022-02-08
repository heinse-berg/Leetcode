package com.leetcodecards.linked.list;

import java.util.*;

public class OddEven {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return head;
        ListNode odd = head, even = head.next, evenHead = even;

        while(odd.next != null && odd.next.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;

            if(even != null && even.next != null) {
                even.next = even.next.next;
                even = even.next;
            }
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        OddEven abc = new OddEven();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        System.out.println(abc.oddEvenList(node));
    }
}
