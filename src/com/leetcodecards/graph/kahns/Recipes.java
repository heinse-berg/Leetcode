package com.leetcodecards.graph.kahns;

import java.util.*;

public class Recipes {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        HashMap<String, HashSet<String>> graph = new HashMap<>();
        HashMap<String, Integer> inDegree = new HashMap<>();
        LinkedList<String> ans = new LinkedList<>();
        ArrayDeque<String> q = new ArrayDeque<>();
        HashSet<String> rcs = new HashSet<>(Arrays.asList(recipes));

        int i = 0;

        for(String supply : supplies)
            inDegree.put(supply, 0);

        for(String recipe : recipes) {
            inDegree.put(recipe, 0);
            for(String ingredient : ingredients.get(i)) {
                if(!graph.containsKey(ingredient))
                    graph.put(ingredient, new HashSet<>());
                graph.get(ingredient).add(recipe);
                inDegree.put(recipe, inDegree.get(recipe) + 1);
            }
        }

        for(Map.Entry<String, Integer> entry : inDegree.entrySet())
            if(entry.getValue() == 0)
                q.addLast(entry.getKey());

        while(!q.isEmpty()) {
            String curr = q.pollFirst();
            if(rcs.contains(curr))
                ans.add(curr);

            for(String deps : graph.get(curr)) {
                int val = inDegree.get(deps);
                inDegree.put(deps, val--);
                if(val == 0)
                    q.addLast(deps);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Recipes abc = new Recipes();
        String[] r = new String[] {"bread"};
        String[] s = new String[] {"yeast","flour","corn"};
        List<List<String>> i = Arrays.asList(Arrays.asList("yeast","flour"));
        System.out.println(abc.findAllRecipes(r, i, s));
        //["bread"], ingredients = [["yeast","flour"]], supplies = ["yeast","flour","corn"]
    }
}
