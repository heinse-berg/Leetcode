package com.leetcodecards.linked.list;

import java.util.*;

public class aDDD {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), c1 = l1, c2 = l2, curr = dummy;
        int carry = 0;

        while(c1 != null && c2 != null) {
            int sum = c1.val + c2.val + carry;
            carry = sum > 9 ? 1 : 0;
            dummy.next = new ListNode(sum % 10);
            dummy = dummy.next;
            c1 = c1.next; c2 = c2.next;
        }

        if(c1 == null && c2 == null && carry == 1)
            dummy.next = new ListNode(1);
        else {
            c1 = (c1 == null) ? c2 : c1;
            while(c1 != null) {
                int sum = c1.val + carry;
                carry = sum > 9 ? 1 : 0;
                dummy.next = new ListNode(sum % 10);
                dummy = dummy.next;
                c1 = c1.next;
                if(sum < 10) {
                    dummy.next = c1;
                    return curr.next;
                }
            }
        }
        if(carry == 1)
            dummy.next = new ListNode(1);

        return curr.next;
    }
    public static void main(String[] args) {
        aDDD abc = new aDDD();
        System.out.println();
    }
}
