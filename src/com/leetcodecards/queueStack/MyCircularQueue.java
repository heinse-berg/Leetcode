package com.leetcodecards.queueStack;

public class MyCircularQueue {

    int[] arr;
    int head;
    int tail;
    int k;

    public MyCircularQueue(int k) {
        arr = new int[k];
        head = -1;
        tail = -1;
        this.k = k;
    }

    public boolean enQueue(int value) {
        if(isFull())
            return false;
        if(isEmpty())
            head = 0;
        tail = (tail+1)%k;
        arr[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty())
            return false;
        if(head == tail) {
            head = -1; tail = -1;
        }
        else
            head = (head+1)%k;

        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : arr[head];
    }

    public int Rear() {
        return isEmpty() ? -1 : arr[tail];
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return (tail+1)%k == head;
    }

    public static void main(String[] args) {
        MyCircularQueue abc = new MyCircularQueue(3);
        abc.enQueue(6);
        abc.Rear();
        abc.Rear();
        abc.deQueue();
        abc.enQueue(5);
        System.out.println();
    }
}//["MyCircularQueue","enQueue","Rear","Rear","deQueue","enQueue","Rear","deQueue","Front","deQueue","deQueue","deQueue"]
//[[6],[6],[],[],[],[5],[],[],[],[],[],[]]
