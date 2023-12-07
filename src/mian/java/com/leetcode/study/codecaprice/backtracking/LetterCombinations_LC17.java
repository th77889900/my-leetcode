package com.leetcode.study.codecaprice.backtracking;

import java.util.*;

/**
 * @author : Cody.Teng
 * @date : 2023-08-04 1:44 p.m.
 */
public class LetterCombinations_LC17 {

    private List<String> result = new ArrayList<>();
    private String path = "";
    private static String[] dic = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public static void main(String[] args) {
        LetterCombinations_LC17 letter = new LetterCombinations_LC17();
        List<String> strings = letter.letterCombinations("23");
        for (String string : strings) {
            System.out.println(string);
        }
    }
    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return result;
        }

        letterHelper(digits, 0);

        return result;
    }

    private void letterHelper(String digits, int index) {
        int size = path.length();
        if (size == digits.length()) {
            result.add(path);
            return;
        }

        int num = Character.getNumericValue(digits.charAt(index));

        String strList = dic[num];

        for (int i = 0; i < strList.length(); i++) {
            char c = strList.charAt(i);
            path = path + c;
            letterHelper(digits, index + 1);
            path = path.substring(0, path.length() - 1);
        }
    }

}
