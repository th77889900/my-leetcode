package com.leetcode.study.codecaprice.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : Cody.Teng
 * @date : 2023-08-04 12:24 p.m.
 */
public class CombineSum_LC216 {

    public static void main(String[] args) {
        CombineSum_LC216 combineSum = new CombineSum_LC216();
        List<List<Integer>> lists = combineSum.combinationSum3(7, 3);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println("===");
        }
    }

    public List<List<Integer>> combinationSum3(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        combineHelper(n, k, 0, 1,path,result);
        return result;
    }

    public void combineHelper(int n, int k, int sum, int startIndex,
                              List<Integer> path, List<List<Integer>> result) {
        int size = path.size();
        if (size <= k && sum > n) {
            return;
        }
        if (size == k) {
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIndex; i <= 9 - k + size + 1; i++) {
            Integer integer = i;
            path.add(integer);
            sum += integer;
            combineHelper(n, k, sum, i + 1, path, result);
            path.remove(integer);
            sum -= integer;
        }
    }

}
