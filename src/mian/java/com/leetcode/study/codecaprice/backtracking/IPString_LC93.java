package com.leetcode.study.codecaprice.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Cody.Teng
 * @date : 2023-08-05 4:02 p.m.
 */
public class IPString_LC93 {

    private List<String> result = new ArrayList<>();
    private String path = "";

    public static final String point = ".";

    public static void main(String[] args) {

        IPString_LC93 ipString = new IPString_LC93();
        List<String> strings = ipString.restoreIpAddresses("101023");
        for (String string : strings) {
            System.out.println(string);
        }

    }

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4) {
            return result;
        }

        backtracking(s, 0, 0);

        return result;
    }

    private void backtracking(String s, int startIndex, int pointSum) {
        if (pointSum == 3) {
            String num = s.substring(startIndex);
            if (!checkValid(num)) {
                return;
            }
            path = path + num;
            result.add(path);
            path = path.substring(0, path.length() - num.length());
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String num = s.substring(startIndex, i + 1);
            if (!checkValid(num)) {
                return;
            }
            path = path + num + point;
            pointSum++;
            backtracking(s, i + 1, pointSum);
            pointSum--;
            path = path.substring(0, path.length() - (num.length() + 1));
        }
    }

    private boolean checkValid(String s) {

        if (s.equals("")) {
            return false;
        }
        if (s.length() > 1 && s.startsWith("0")) {
            return false;
        }

        Long num = Long.valueOf(s);

        if (num > 255L) {
            return false;
        }

        return true;
    }



}
