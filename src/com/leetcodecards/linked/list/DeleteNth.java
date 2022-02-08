package com.leetcodecards.linked.list;

import java.util.*;

public class DeleteNth {

    static class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head, prev = null;

        n--;
        while(n > 0) {
            fast = fast.next;
            n--;
        }

        if(fast != null) {
            while(fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next;
            }
        }

        if(slow == head)
            head = head.next;

        else
            prev.next = slow.next;

        return head;
    }

    public static void main(String[] args) {
        DeleteNth abc = new DeleteNth();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(7);

        System.out.println(abc.removeNthFromEnd(node, 3));
    }
}
