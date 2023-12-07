package com.leetcode.study.codecaprice.array.binary.search;

/**
 * @author : Cody.Teng
 * @date : 2023-07-21 4:52 p.m.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int i = binarySearch_LC704(nums, 9);
        System.out.println(i);
    }

    /**
     * framework code
     */
    public void binarySearch(int[] nums, int target) {
        int left = 0;
        int right = 0;
        while (true) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return;
            } else if (nums[mid] < target) {

            } else if (nums[mid] > target) {

            }
        }
    }

    public static int binarySearch_LC704(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static int binarySearchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left >= nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    private static int binarySearchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left >= nums.length) {
            return -1;
        }
        return nums[left] == target ? left - 1 : -1;
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = binarySearchLeft(nums, target);
        int right = binarySearchRight(nums, target);
        return new int[]{left, right};
    }

}
