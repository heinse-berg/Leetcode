package com.playground;

import java.util.*;
import java.util.stream.Collectors;

public class Recipe {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        Set<String> supply = Arrays.stream(supplies).collect(Collectors.toSet());
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < ingredients.size(); i++) map.put(recipes[i], ingredients.get(i));

        HashSet<String> dep = new HashSet<>(), non_dep = new HashSet<>();
        List<String> res = new ArrayList<>();
        boolean flag;

        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            flag = true;
            for(String st : entry.getValue()) {
                if(map.containsKey(st)) {
                    dep.add(entry.getKey());
                    flag = false;
                    break;
                }
            }
            if(flag)
                non_dep.add(entry.getKey());
        }

        for(String s : non_dep) {
            flag = true;
            for(String a : map.get(s)) {
                if(!supply.contains(a)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                supply.add(s);
                res.add(s);
            }
        }

        for(String s : dep) {
            flag = true;
            for(String a : map.get(s)) {
                if(!supply.contains(a)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                supply.add(s);
                res.add(s);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Recipe abc = new Recipe();
        ArrayList<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("yeast","flour"));
        list.add(Arrays.asList("bread","meat"));
        list.add(Arrays.asList("sandwich","meat","bread"));
        System.out.println(abc.findAllRecipes(new String[]{"bread","sandwich","burger"}, list, new String[] {"yeast","flour","meat"}));
    }
}
/*
["bread","sandwich","burger"]
[["yeast","flour"],["bread","meat"],["sandwich","meat","bread"]]
["yeast","flour","meat"]
 */