package com.leetcodecards.recursion1;

import java.util.*;

public class LinkedList2Reverse {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode first = head;
        ListNode second = first.next;

        first.next = swapPairs(second.next);
        second.next = first;

        return second;
    }

    public static void main(String[] args) {
        LinkedList2Reverse abc = new LinkedList2Reverse();
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);
        ListNode ans = abc.swapPairs(head);
        System.out.println();
    }
}
