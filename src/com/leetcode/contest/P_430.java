package com.leetcode.contest;

import java.util.*;

public class P_430 {

    public Node flatten(Node head) {
        Node curr = head;
        while(curr != null) {
            while(curr != null && curr.child == null) {
                curr = curr.next;
            }
            if(curr == null)
                return head;

            curr = curr.next;
        }

        return head;
    }

    /*public Node flatten(Node head) {
        Node curr = head;
        while(curr != null) {
            if(curr.child != null) {
                Node temp = curr.child;
                while(temp.next != null)
                    temp = temp.next;
                temp.next = curr.next;
                if(curr.next != null)
                    curr.next.prev = temp;
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
            }
            curr = curr.next;
        }
        return head;
    }*/

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public static void main(String[] args) {
        P_430 abc = new P_430();
        System.out.println();
    }
}
