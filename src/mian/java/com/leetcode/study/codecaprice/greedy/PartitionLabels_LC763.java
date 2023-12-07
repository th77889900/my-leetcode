package com.leetcode.study.codecaprice.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Cody.Teng
 * @date : 2023-08-10 11:23 a.m.
 */
public class PartitionLabels_LC763 {

    public static void main(String[] args) {

        List<Integer> list = partitionLabels("aa");
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public static List<Integer> partitionLabels(String s) {

        List<Integer> result = new ArrayList<>();
        if (s.length() < 1) {
            return result;
        }
        Map<Character, Integer> location = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            location.put(c, i);
        }
        Integer maxIndex = location.get(s.charAt(0));
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer cIndex = location.get(c);
            if (i <= maxIndex && cIndex <= maxIndex) {
                count++;
            } else if (i < maxIndex && cIndex > maxIndex) {
                maxIndex = cIndex;
                count++;
            } else if (i > maxIndex && cIndex > maxIndex) {
                result.add(count);
                count = 0;
                count++;
                maxIndex = cIndex;
            }
        }
        if (count > 0) {
            result.add(count);
        }
        return result;
    }
}
