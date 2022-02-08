package com.leetcodecards.linked.list;

import java.util.*;

public class Random {

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
            next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node ans = new Node(0), curr = head, neu = ans;
        HashMap<Node, Node> map  = new HashMap<>();

        while(curr != null) {
            Node temp = new Node(curr.val);
            ans.next = temp;
            map.put(curr, temp);
            curr = curr.next;
            ans = ans.next;
        }

        ans = neu.next;
        curr = head;
        while(curr != null) {

            ans.random = map.get(curr.random);

            ans = ans.next;
            curr = curr.next;
        }

        return neu.next;
    }

    public static void main(String[] args) {
        Random abc = new Random();
        System.out.println();
    }
}
