package com.playground;

import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
    ArrayBlockingQueue<Integer> q;
    int counter = 0;

    Producer(ArrayBlockingQueue<Integer> q) {
        this.q = q;
    }

    @Override
    public void run() {
        while(true) {
            try {
                q.put(produce());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int produce() {
        return counter++;
    }
}

class Consumer implements Runnable {

    ArrayBlockingQueue<Integer> q;

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println(q.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class QueuePractice {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(100);
    }
}
