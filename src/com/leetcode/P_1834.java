package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Job {
    int[] arr;
    int taskIndex;

    Job(int[] arr, int index) {
        this.taskIndex = index;
        this.arr = arr;
    }
}

public class P_1834 {
    Comparator<Job> comp = (a, b) -> {
        if(a.arr[1] < b.arr[1])
            return -1;
        else if(a.arr[1] > b.arr[1])
            return 1;
        else {
            if(a.taskIndex < b.taskIndex)
                return -1;
            else if(a.taskIndex > b.taskIndex)
                return 1;
            return 0;
        }
    };

    public int[] getOrder(int[][] tasks) {

        PriorityQueue<Job> enqueueTime = new PriorityQueue<>(Comparator.comparingInt(a -> a.arr[0]));
        PriorityQueue<Job> priorityQueue = new PriorityQueue<>(comp);
        int i, res[] = new int[tasks.length], resIndex = 0, timeElapsed = 0;

        for(i = 0; i < tasks.length; i++)
            enqueueTime.offer(new Job(tasks[i], i));

        Job first = enqueueTime.poll();
        while(enqueueTime.size() > 0 && enqueueTime.peek().arr[0] == first.arr[0])
            priorityQueue.offer(enqueueTime.poll());
        if(priorityQueue.size() == 0) {
            enqueueTime.offer(first);
            timeElapsed += enqueueTime.peek().arr[1] + enqueueTime.peek().arr[0];
            res[resIndex++] = enqueueTime.poll().taskIndex;
        }
        else {
            priorityQueue.offer(first);
            timeElapsed += priorityQueue.peek().arr[1] + priorityQueue.peek().arr[0];
            res[resIndex++] = priorityQueue.poll().taskIndex;
        }

        while(resIndex < tasks.length) {
            while(enqueueTime.size() > 0 && enqueueTime.peek().arr[0] <= timeElapsed)
                priorityQueue.offer(enqueueTime.poll());
            if(priorityQueue.size() > 0) {
                if(timeElapsed > priorityQueue.peek().arr[0])
                    timeElapsed += priorityQueue.peek().arr[1];
                else
                    timeElapsed = priorityQueue.peek().arr[1] + priorityQueue.peek().arr[0];
                res[resIndex++] = priorityQueue.poll().taskIndex;
            }
            else {
                timeElapsed = enqueueTime.peek().arr[1] + enqueueTime.peek().arr[0];
                res[resIndex++] = enqueueTime.poll().taskIndex;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //enter code
        int[][] arr = {{1,2}, {2,4}, {3,2}, {4,1}};
        //int[][] arr = {{7,10},{7,12},{7,5},{7,4},{7,2}};
        System.out.println(Arrays.toString(new P_1834().getOrder(arr)));
    }
}