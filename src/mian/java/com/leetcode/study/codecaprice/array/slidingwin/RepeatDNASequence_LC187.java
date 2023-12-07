package com.leetcode.study.codecaprice.array.slidingwin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author : Cody.Teng
 * @date : 2023-07-21 12:26 a.m.
 */
public class RepeatDNASequence_LC187 {

    public List<String> findRepeatDNA(String s, int l) {

        List<String> res = new ArrayList<>();

        if (s == null || s.length() < l) {
            return res;
        }

        int n = s.length();
        HashMap<String, Integer> window = new HashMap<>();
        for (int i = 0; i < n - l; i++) {
            String c = s.substring(i, i + l);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (window.get(c) == 2) {
                res.add(c);
            }
        }
        return res;
    }

}
