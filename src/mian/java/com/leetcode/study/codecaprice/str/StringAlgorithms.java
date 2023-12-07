package com.leetcode.study.codecaprice.str;

/**
 * @author : Cody.Teng
 * @date : 2023-07-26 5:09 p.m.
 */
public class StringAlgorithms {

    public static void reverseString_LC344(char[] s) {

        if (s == null || s.length <= 1) {
            return;
        }

        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static String reverseString_LC541(String s, int k) {

        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i = i + 2 * k) {

            int left = i;

            int right = Math.min(chars.length - 1, i + k - 1);

            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        String s1 = replaceSpace_offer05(s);
        System.out.println(s1);
    }

    public static String replaceSpace_offer05(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int oLen = s.length();
        boolean flag = true;
        for (int i = 0; i < oLen; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                s += "  ";
                flag = false;
            }
        }
        if (flag) {
            return s;
        }

        int left = oLen - 1;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            char l = chars[left];
            char r = chars[right];

            if (chars[left] == ' ') {
                chars[right] = '0';
                chars[--right] = '2';
                chars[--right] = '%';
                left--;
                right--;
            }else {
                chars[right] = chars[left];
                right--;
                left--;
            }
        }

        return new String(chars);
    }

}
