package com.leetcodecards.linked.list;

import java.util.*;

public class InsertCyclic {

    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        Node temp = new Node(insertVal);

        if(head == null) {
            head = temp;
            head.next = head;
            return head;
        }

        Node curr = head;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        do {
            min = Math.min(min, curr.val);
            max = Math.max(max, curr.val);
            curr = curr.next;
        } while (curr != head);

        if(insertVal <= min || insertVal >= max) {
            while (!(curr.val != max && curr.next.val != min)) {
                curr = curr.next;
            }
        }

        else {
            while(!(insertVal >= curr.val && insertVal <= curr.next.val)) {
                curr = curr.next;
            }
        }

        temp.next = curr.next;
        curr.next = temp;

        return head;
    }

    public static void main(String[] args) {
        InsertCyclic abc = new InsertCyclic();
        Node node = new Node(3);
        node.next = new Node(3);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = node;

        System.out.println(abc.insert(node, 0));
    }
}
