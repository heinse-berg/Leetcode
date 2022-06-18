package com.leetcodecards.graph.dfs;

import javax.swing.*;
import java.util.*;

public class Itinerary {
    /*HashMap<String, LinkedList<String>> map = new HashMap<>();
    int flights;
    List<String> res;


    public boolean backtrack(String from, LinkedList<String> route) {
        route.add(from);
        if(route.size() == flights+1) {
            res = (List<String>) route.clone();
            return true;
        }
        List<String> destinations = map.get(from);
        if(destinations != null) {
            Collections.sort(destinations);
            for (int i = 0; i < destinations.size(); i++) {
                String destination = destinations.get(i);
                destinations.remove(i);
                if (backtrack(destination, route))
                    return true;
                destinations.add(i, destination);
                route.removeLast();
            }
        }
        return false;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket : tickets) {
            String from = ticket.get(0);
            if(!map.containsKey(from))
                map.put(from, new LinkedList<>());
            map.get(from).add(ticket.get(1));
        }
        flights = tickets.size();
        backtrack("JFK", new LinkedList<>());
        return res;
    }*/

    List<String> res = new LinkedList<>();
    HashMap<String, Integer> pointers = new HashMap<>();

    public void dfs(String curr, HashMap<String, LinkedList<String>> m) {
        res.add(curr);

        if(m.containsKey(curr)) {
            List<String> set = m.get(curr);
            while(pointers.get(curr) < set.size()) {
                String s = set.get(pointers.get(curr));
                pointers.put(curr, pointers.get(curr)+1);
                dfs(s, m);
            }

            if(set.size() == 0)
                m.remove(curr);
        }
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, LinkedList<String>> map = new HashMap<>();

        for(List<String> l : tickets) {
            String from = l.get(0), to = l.get(1);
            map.putIfAbsent(from, new LinkedList<>());
            map.get(from).add(to);
        }

        for(Map.Entry<String, LinkedList<String>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
            pointers.put(entry.getKey(), 0);
        }

        dfs("JFK", map);

        return res;
    }

    public static void main(String[] args) {
        Itinerary abc = new Itinerary();
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("JFK","SFO"));
        list.add(Arrays.asList("JFK","ATL"));
        list.add(Arrays.asList("SFO","ATL"));
        list.add(Arrays.asList("ATL","JFK"));
        list.add(Arrays.asList("ATL","SFO"));

        System.out.println(abc.findItinerary(list));
    }
}
//[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
//["JFK","SFO"], ["JFK","ATL"], ["SFO","ATL"], ["ATL","JFK"], ["ATL","SFO"]
//JFK","ATL","JFK","SFO","ATL","SFO"]
//[["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
//["JFK","ATL","JFK","SFO","ATL","SFO"]
