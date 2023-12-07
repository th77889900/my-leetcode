package com.leetcode.study.codecaprice.dp;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : Cody.Teng
 * @date : 2023-08-12 11:17 a.m.
 */
public class Fib_LC506 {

    public static void main(String[] args) {
        int fib = fib(3);
        System.out.println(fib);
    }
    public static int fib(int n) {

        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];

    }

}
