package com.leetcode.study.codecaprice.greedy;

/**
 * @author : Cody.Teng
 * @date : 2023-08-08 7:32 p.m.
 */
public class MaxProfit_LC122 {

    public int maxProfit(int[] prices) {

        if (prices.length == 1) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {

            int profit = prices[i + 1] - prices[i];
            if (profit > 0) {
                result += profit;
            }
        }

        return result;
    }
}
