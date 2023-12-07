package com.leetcode.study.codecaprice.array.diffsum;

/**
 * 差分算法
 *
 * @author : Cody.Teng
 * @date : 2023-07-14 9:22 p.m.
 */
public class Difference {

    private int[] diff;

    public Difference(int[] numArr) {
        if (numArr == null) {
            return;
        }

        diff = new int[numArr.length];
        diff[0] = numArr[0];
        for (int i = 1; i < numArr.length; i++) {
            diff[i] = numArr[i] - numArr[i - 1];
        }
    }

    public void increment(int start, int end, int val) {
        diff[start] += val;
        if (end + 1 < diff.length) {
            diff[end+1] -=  - val;
        }
    }

    public int[] result() {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }

        return res;
    }

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ints = new int[length];
        Difference difference = new Difference(ints);

        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int val = update[2];
            difference.increment(start, end, val);
        }

        return difference.result();
    }

}
