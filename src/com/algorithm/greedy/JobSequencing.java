package com.algorithm.greedy;

import javafx.util.Pair;

import java.util.*;

public class JobSequencing {
    int deadline;
    int profit;

    JobSequencing(int deadline, int profit) {
        this.deadline = deadline;
        this.profit = profit;
    }

    public static int sequencing(List<JobSequencing> list) {
        list.sort((a, b) -> b.profit - a.profit);
        int profit = 0, days = 0;
        for(JobSequencing job : list) {
            if(job.deadline >= days) {
                profit += job.profit;
                days++;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        List<JobSequencing> jobSequencings = new ArrayList<>();
        jobSequencings.add(new JobSequencing(1, 25));
        jobSequencings.add(new JobSequencing(1, 19));
        jobSequencings.add(new JobSequencing(2, 100));
        jobSequencings.add(new JobSequencing(2, 27));
        jobSequencings.add(new JobSequencing(3, 15));

        System.out.println(sequencing(jobSequencings));
    }
}
