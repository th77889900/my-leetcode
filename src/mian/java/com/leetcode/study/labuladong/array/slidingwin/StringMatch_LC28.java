package com.leetcode.study.labuladong.array.slidingwin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Cody.Teng
 * @date : 2023-07-21 9:31 a.m.
 */
public class StringMatch_LC28 {

    public int strMatch(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return -1;
        }

        int l = t.length();
        int n = s.length();

        for (int i = 0; i < n - l; i++) {
            if (s.substring(i, i + l).equals(t)) {
                return i;
            }
        }
        return -1;
    }
}
