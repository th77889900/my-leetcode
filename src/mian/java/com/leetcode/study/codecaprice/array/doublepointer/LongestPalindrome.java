package com.leetcode.study.codecaprice.array.doublepointer;

/**
 * Determine the longest palindrome string
 * @author : Cody.Teng
 * @date : 2023-07-14 11:44 a.m.
 */
public class LongestPalindrome {

    public String getLongestPalindrome(String str) {

        String res = "";

        for (int i = 0; i < str.length(); i++) {
            String strOdd = palindrome(str, i, i);
            String strEven = palindrome(str, i, i++);

            res = res.length() > strOdd.length() ? res : strOdd;
            res = res.length() > strEven.length() ? res : strEven;
        }

        return res;
    }

    private String palindrome(String str, int l, int r) {

        if (str == null) {
            return null;
        }

        char[] chars = str.toCharArray();

        while (l >= 0 && r < str.length() && chars[l] == chars[r]) {
            l--;
            r++;
        }

        return str.substring(l + 1, r);
    }

}
