package com.leetcode.study.codecaprice.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : Cody.Teng
 * @date : 2023-08-05 2:22 p.m.
 */
public class StringPartition_LC131 {

    private List<List<String>> result = new ArrayList<>();
    private List<String> path = new LinkedList<>();

    public static void main(String[] args) {
        StringPartition_LC131 sp = new StringPartition_LC131();
        List<List<String>> aab = sp.partition("aab");
        for (List<String> strings : aab) {
            for (String string : strings) {
                System.out.println(string);
            }

        }
    }

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return result;
        }


        backtracking(s, 0);
        return result;
    }

    private void backtracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                String sonStr = s.substring(startIndex, i + 1);
                path.add(sonStr);
            } else {
                continue;
            }
            backtracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    //判断是否是回文串
    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
