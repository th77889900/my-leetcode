package com.leetcode.study.codecaprice.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Cody.Teng
 * @date : 2023-08-06 10:53 p.m.
 */
public class ContentChildren_LC455 {

    public static void main(String[] args) {
        ContentChildren_LC455 child = new ContentChildren_LC455();
        int result = child.findContentChildren_2(new int[]{1, 2, 3}, new int[]{1, 1});
        System.out.println(result);

    }

    public int findContentChildren(int[] g, int[] s) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int biscuits : s) {
            map.put(biscuits, map.getOrDefault(biscuits, 0) + 1);    
        }
        Arrays.sort(s);
        int result = 0;
        for (int i = 0; i < g.length; i++) {
            int appetite = g[i];
            for (int j = 0; j < s.length; j++) {
                int biscuits = s[j];
                if (biscuits >= appetite && map.getOrDefault(biscuits, 0) > 0) {
                    map.put(biscuits, map.getOrDefault(biscuits, 0) - 1);
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    public int findContentChildren_2(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int index = s.length - 1;
        int result = 0;

        for (int i = g.length - 1; i >= 0; i--) {

            while (index >= 0 && s[index] >= g[i]) {
                index--;
                result++;
                break;
            }
        }

        return result;
    }
}
