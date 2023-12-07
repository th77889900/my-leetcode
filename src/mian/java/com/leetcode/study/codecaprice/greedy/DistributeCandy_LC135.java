package com.leetcode.study.codecaprice.greedy;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : Cody.Teng
 * @date : 2023-08-09 4:10 p.m.
 */
public class DistributeCandy_LC135 {

    public static void main(String[] args) {
        int candy = candy(new int[]{5, 4, 3, 4, 5});
        System.out.println(candy);
    }

    public static int candy(int[] ratings) {

        ConcurrentHashMap map = new ConcurrentHashMap();

        map.size();

        if (ratings.length == 1) {
            return 1;
        }

        int result = 0;

        int[] vec = new int[ratings.length];
        vec[0] = 1;
        // from left to right
        for (int i = 1; i < ratings.length; i++) {
            vec[i] = ratings[i] > ratings[i - 1] ? vec[i - 1] + 1 : 1;
        }

        // from right to left
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                vec[i - 1] = Math.max(vec[i - 1], vec[i] + 1);
            }
        }

        for (int v : vec) {
            result += v;
        }

        return result;
    }
}
