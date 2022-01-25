package com.leetcodecards.graph.dfs;

import java.util.*;

public class Itinerary {
    HashMap<String, LinkedList<String>> map = new HashMap<>();
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
    }

    public static void main(String[] args) {
        Itinerary abc = new Itinerary();
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("JFK","KUL"));
        list.add(Arrays.asList("JFK","NRT"));
        list.add(Arrays.asList("NRT","JFK"));

        System.out.println(abc.findItinerary(list));
    }
}
//[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
//["JFK","SFO"], ["JFK","ATL"], ["SFO","ATL"], ["ATL","JFK"], ["ATL","SFO"]
//JFK","ATL","JFK","SFO","ATL","SFO"]
//[["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
