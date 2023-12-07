package com.leetcode.study.codecaprice.backtracking;

import java.util.*;

/**
 * @author : Cody.Teng
 * @date : 2023-08-06 5:08 p.m.
 */
public class Itinerary_LC332 {

    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0) {
            return result;
        }

        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);

            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<>());
            }
            map.get(src).add(dst);
        }

        bfs("JFK");
        Collections.reverse(result);
        return result;
    }

    private void bfs(String s) {

        while (map.containsKey(s) && map.get(s).size() >= 1) {
            String dst = map.get(s).poll();
            bfs(dst);
        }
        result.add(s);
    }
}
