package com.leetcode.study.codecaprice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : Cody.Teng
 * @date : 2023-08-06 2:01 p.m.
 */
public class Permute_LC46 {

    public static void main(String[] args) {
        Permute_LC46 per = new Permute_LC46();

        List<List<Integer>> permute = per.permute_LC47(new int[]{1, 1, 2});

        for (List<Integer> list : permute) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println("");
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        backtracking(nums, path, result);
        return result;
    }

    private void backtracking(int[] nums, List<Integer> path, List<List<Integer>> result) {

        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (path.contains(num)) {
                continue;
            }
            path.add(num);
            backtracking(nums, path, result);
            path.remove(path.size() - 1);
        }
    }


    public List<List<Integer>> permute_LC47(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        Arrays.sort(nums);
        int[] used = new int[nums.length];
        backtracking47(nums, used, path, result);
        return result;
    }

    private void backtracking47(int[] nums, int[] used, List<Integer> path, List<List<Integer>> result) {

        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (i > 0 && num == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }
            if (used[i] == 1) {
                continue;
            }
            path.add(num);
            used[i] = 1;
            backtracking47(nums, used, path, result);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }

}
