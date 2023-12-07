package com.leetcode.study.codecaprice.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : Cody.Teng
 * @date : 2023-08-05 9:53 a.m.
 */
public class CombineSum_LC39 {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        CombineSum_LC39 combine = new CombineSum_LC39();
        List<List<Integer>> lists = combine.combinationSum(new int[]{8,7,4,3}, 11);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }

    }
    

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSumHelper(candidates, target, 0, 0);
        return result;
    }

    private void combinationSumHelper(int[] candidates, int target, int sum, int index) {

        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            int num = candidates[i];
            sum = sum + num;
            path.add(num);
            combinationSumHelper(candidates, target, sum, i);
            sum = sum - num;
            path.remove(path.size() - 1);
        }
    }

}
