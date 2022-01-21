package com.leetcodecards.recursion1;

import javafx.util.Pair;

public class LinkedListReverse {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        LinkedListReverse abc = new LinkedListReverse();
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);
        ListNode l = abc.reverseList(head);
        System.out.println();
    }
}
