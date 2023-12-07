package com.leetcode.study.codecaprice.array.randomweights;

/**
 * random algorithms with weights
 * @author : Cody.Teng
 * @date : 2023-07-22 10:52 a.m.
 */
public class RandomWeight {

    public static void main(String[] args) {

        RandomWeight weight = new RandomWeight(new int[]{1, 3});

        for (int i = 0; i < 5; i++) {
            System.out.println(weight.pickIndex());
        }

    }

    int[] sum;
    public RandomWeight(int[] w) {
        int n = w.length;
        sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + w[i - 1];
    }

    public int pickIndex() {
        int n = sum.length;
        int t = (int) (Math.random() * sum[n - 1]) + 1;
        int l = 1, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (sum[mid] >= t) r = mid;
            else l = mid + 1;
        }
        return r - 1;
    }
}
