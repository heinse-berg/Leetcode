package com.playground.oa.atlassian;

import javafx.util.Pair;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class RateLimiter {

    public HashMap<String, List<LocalTime>> getUsers(List<Pair<String, LocalTime>> logs) {
        HashMap<String, List<LocalTime>> result = new HashMap<>();
        HashMap<String, List<LocalTime>> map = new HashMap<>();

        for(Pair<String, LocalTime> log : logs) {
            map.putIfAbsent(log.getKey(), new ArrayList<>());
            map.get(log.getKey()).add(log.getValue());
        }

        for(List<LocalTime> lo : map.values())
            Collections.sort(lo);

        for(Map.Entry<String, List<LocalTime>> entry : map.entrySet()) {
            List<LocalTime> lo = entry.getValue();
            int i = 0, n = lo.size();
            while (i < n) {
                LocalTime start = lo.get(i);
                int index = i;
                while(i < n && Duration.between(start, lo.get(i)).toMinutes() < 60) {
                    i++;
                }
                if(i-index >= 3) {
                    result.put(entry.getKey(), entry.getValue().subList(index, i+1));
                    break;
                }
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
