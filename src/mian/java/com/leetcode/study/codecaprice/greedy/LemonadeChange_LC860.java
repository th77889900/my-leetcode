package com.leetcode.study.codecaprice.greedy;

/**
 * @author : Cody.Teng
 * @date : 2023-08-09 4:39 p.m.
 */
public class LemonadeChange_LC860 {

    public static void main(String[] args) {
        boolean b = lemonadeChange(new int[]{5, 5, 5, 10, 20});
        System.out.println();
    }

    public static boolean lemonadeChange(int[] bills) {

        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            }else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            }else if (bill == 20) {
                if (five == 0) {
                    return false;
                }
                if (ten > 0) {
                    ten--;
                    five--;
                }else if (five < 3) {
                    return false;
                }else {
                    five -= 3;
                }
            }
        }

        return true;
    }
}
