package com.leetcode.study.codecaprice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : Cody.Teng
 * @date : 2023-08-06 12:09 p.m.
 */
public class Subsets_LC78 {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        Subsets_LC78 sub = new Subsets_LC78();
        List<List<Integer>> subsets = sub.subsets_LC90(new int[]{1, 1, 2});
        for (List<Integer> subset : subsets) {
            for (Integer integer : subset) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        result.add(new ArrayList<>());
        return result;
    }

    private void backtracking(int[] nums, int startIndex) {

        for (int i = startIndex; i < nums.length; i++) {
            int num = nums[i];
            path.add(num);
            result.add(new ArrayList<>(path));
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsets_LC90(int[] nums) {
        Arrays.sort(nums);
        int[] used = new int[nums.length];
        backtracking90(nums, 0, used);
        result.add(new ArrayList<>());
        return result;
    }

    private void backtracking90(int[] nums, int startIndex, int[] used) {
        for (int i = startIndex; i < nums.length; i++) {
            int num = nums[i];
            if (i > 0 && num == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }
            used[i] = 1;
            path.add(num);
            result.add(new ArrayList<>(path));
            backtracking90(nums, i + 1, used);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }
}
