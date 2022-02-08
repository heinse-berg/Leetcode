package com.leetcodecards.linked.list;

import java.util.*;

public class Rotate {

    static class ListNode {
        public ListNode next;
        public int val;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
            return head;

        int len = 1, i = 0;
        ListNode curr = head;

        while(curr.next != null) {
            curr = curr.next;
            len++;
        }

        curr.next = head;
        k = k%len;

        while(i < len-k) {
            curr = curr.next;
            i++;
        }

        head = curr.next;
        curr.next = null;
        return head;
    }

    public static void main(String[] args) {
        Rotate abc = new Rotate();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(7);
        node.next.next.next.next.next.next.next = new ListNode(8);
        System.out.println(abc.rotateRight(node, 2));
    }
}
