package com.leetcode.study.codecaprice.backtracking;

import java.util.*;

/**
 * @author : Cody.Teng
 * @date : 2023-08-06 12:57 p.m.
 */
public class Subsequences_LC491 {

    public static void main(String[] args) {
        Subsequences_LC491 subsequences = new Subsequences_LC491();
        List<List<Integer>> result = subsequences.findSubsequences(new int[]{1,2,3,4,5,6,7,8,9,10,1,1,1,1,1});
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer + ".");
            }
            System.out.println();
        }
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
//    public List<List<Integer>> findSubsequences(int[] nums) {
//        backTracking(nums, 0);
//        return result;
//    }
//    private void backTracking(int[] nums, int startIndex){
//        if(path.size() >= 2)
//            result.add(new ArrayList<>(path));
//        HashSet<Integer> hs = new HashSet<>();
//        for(int i = startIndex; i < nums.length; i++){
//            if(!path.isEmpty() && path.get(path.size() -1 ) > nums[i] || hs.contains(nums[i]))
//                continue;
//            hs.add(nums[i]);
//            path.add(nums[i]);
//            backTracking(nums, i + 1);
//            path.remove(path.size() - 1);
//        }
//    }


    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        backtracking(nums, 0, path, result);
        return result;
    }

    private void backtracking(int[] nums, int startIndex, List<Integer> path, List<List<Integer>> result) {

        Set<Integer> levelSet = new HashSet<>();

        for (int i = startIndex; i < nums.length; i++) {
            int num = nums[i];
            int size = path.size();
            if (levelSet.contains(num)) {
                continue;
            }
            if (size > 0) {
                Integer last = path.get(size - 1);
                if (num >= last) {
                    path.add(num);
                } else {
                    continue;
                }
            } else {
                path.add(num);
            }
            levelSet.add(num);
            if (path.size() > 1) {
                result.add(new ArrayList<>(path));
            }
            backtracking(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
