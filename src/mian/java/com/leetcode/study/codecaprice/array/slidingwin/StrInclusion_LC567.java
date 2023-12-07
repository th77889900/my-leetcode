package com.leetcode.study.codecaprice.array.slidingwin;

/**
 * @author : Cody.Teng
 * @date : 2023-07-15 12:09 a.m.
 */
public class StrInclusion_LC567 {

    public boolean checkStrInclusion(String s, String t) {

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char d = t.charAt(0);
            if (d == c) {
                for (int j = 1; j < t.length(); j++) {
                    if (i + j >= s.length()) {
                        return false;
                    }
                    if (t.charAt(j) != s.charAt(i + j)) {
                        break;
                    }
                }
                return true;
            }
        }
        return false;
    }

}
