package com.leetcode.study.codecaprice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : Cody.Teng
 * @date : 2023-08-05 9:53 a.m.
 */
public class CombineSum_LC40 {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        CombineSum_LC40 combine = new CombineSum_LC40();
        List<List<Integer>> lists = combine.combinationSum(new int[]{8,7,4,3}, 11);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }

    }
    

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        int[] used = new int[candidates.length];
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, 0, 0, used);
        return result;
    }

    private void combinationSumHelper(int[] candidates, int target, int sum, int index, int[] used) {

        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // remove repeat
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == 0) {
                continue;
            }
            int num = candidates[i];
            sum = sum + num;
            path.add(num);
            used[i] = 1;
            combinationSumHelper(candidates, target, sum, i + 1, used);
            sum = sum - num;
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }

}
