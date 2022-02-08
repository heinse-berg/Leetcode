package com.leetcodecards.linked.list;

public class MyLinkedList {

    static class ListNode {
        public ListNode next;
        public int val;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    ListNode head;
    int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        if(index > size-1 || index < 0)
            return -1;

        ListNode curr = head;

        while(index > 0) {
            curr = curr.next;
            index--;
        }

        return curr.val;
    }

    public void addAtHead(int val) {
        ListNode temp = head;
        head = new ListNode(val);
        head.next = temp;
        size++;
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if(index > size || index < 0)
            return;
        if(index == 0)
            addAtHead(val);
        else {
            int len = index-1;
            ListNode curr = head;
            while(len > 0) {
                curr = curr.next;
                len--;
            }
            if(curr == null)
                head = new ListNode(val);
            else {
                ListNode temp = new ListNode(val);
                temp.next = curr.next;
                curr.next = temp;
            }
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if(index > size-1 || index < 0 || head == null)
            return;

        if(index == 0) {
            head = head.next;
        }
        else {
            ListNode curr = head, prev = null;

            while (index > 0) {
                prev = curr;
                curr = curr.next;
                index--;
            }

            prev.next = curr.next;
        }
        size--;
    }

    public static void main(String[] args) {
        MyLinkedList abc = new MyLinkedList();
        abc.addAtHead(1);
        abc.addAtTail(2);
        abc.addAtIndex(1,2);
        abc.get(1);
        abc.deleteAtIndex(1);
        abc.get(1);

        System.out.println();
    }
}
//["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
//[[],[1],[3],[1,2],[1],[1],[1]]