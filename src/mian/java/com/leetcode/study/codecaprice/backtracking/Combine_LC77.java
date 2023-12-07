package com.leetcode.study.codecaprice.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : Cody.Teng
 * @date : 2023-08-03 10:37 a.m.
 */
public class Combine_LC77 {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new LinkedList<>();

    public List<List<Integer>> combineColl(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    public void backtracking(int n, int k, int startIndex) {

        int size = path.size();
        if (size == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n - (k - size) + 1; i++) {
            Integer integer = new Integer(i);
            path.add(integer);
            backtracking(n, k, i + 1);
            path.remove(integer);
        }

    }

    public static void main(String[] args) {

        Combine_LC77 combine = new Combine_LC77();
        List<List<Integer>> combine1 = combine.combineColl(4, 4);

        for (List<Integer> list : combine1) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }

    }

}
