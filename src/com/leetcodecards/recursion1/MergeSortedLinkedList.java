package com.leetcodecards.recursion1;

import java.util.*;

public class MergeSortedLinkedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode curr, head;
        if(list1.val <= list2.val) {
            curr = list1; list1 = list1.next;
        }
        else {
            curr = list2;
            list2 = list2.next;
        }
        head = curr;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                curr.next = list1; list1 = list1.next;
            }
            else {
                curr.next = list2; list2 = list2.next;
            }
            curr = curr.next;
        }
        while(list2 != null) {
            curr.next = list2;
            list2 = list2.next;
        }
        while(list1 != null) {
            curr.next = list1;
            list1 = list1.next;
        }
        return head;
    }

    public static void main(String[] args) {
        MergeSortedLinkedList abc = new MergeSortedLinkedList();
        ListNode head1 = new ListNode(-9);
        head1.next = new ListNode(3);
        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(7);
        abc.mergeTwoLists(head1, head2);
        System.out.println();
    }
}
