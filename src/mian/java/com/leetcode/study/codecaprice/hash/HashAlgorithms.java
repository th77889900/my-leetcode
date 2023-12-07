package com.leetcode.study.codecaprice.hash;

import java.util.*;

/**
 * @author : Cody.Teng
 * @date : 2023-07-25 4:47 p.m.
 */
public class HashAlgorithms {

    public static void main(String[] args) {

        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};

        List<List<Integer>> lists = fourSum_LC18(nums, -11);

        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + ", ");
            }
            System.out.println();

        }

    }

    public static boolean isAnagram_LC242(String s, String t) {

        if (s == null || s.length() < 1 || t == null || t.length() < 1 || s.length() != t.length()) {
            return false;
        }

        // init hash table and use s to value it
        int[] hashTable = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            hashTable[chars[i] - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            hashTable[c - 'a']--;
            if (hashTable[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] intersection_LC349(int[] nums1, int[] nums2) {

        HashSet<Integer> contain = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            contain.add(num);
        }

        for (int i = 0; i < nums2.length; i++) {
            int num = nums2[i];
            if (contain.contains(num)) {
                result.add(num);
            }
        }

        if (result.size() == 0) {
            return new int[0];
        }


        int[] res = new int[result.size()];
        int i = 0;
        for (Integer number : result) {
            res[i] = number;
            i++;
        }

        return res;
    }

    public static boolean isHappy_LC202(int num) {
        if (num <= 0) {
            return false;
        }

        int sum = 0;

        HashSet<Integer> contain = new HashSet<>();

        while (sum != 1) {
            while (num > 0) {
                int remainder = num % 10;
                sum += remainder * remainder;
                num = num / 10;
            }
            if (!contain.add(sum)) {
                return false;
            }
            num = sum;
            if (sum != 1) {
                sum = 0;
            }
        }
        return true;
    }

    public static int[] twoSum_LC349(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.put(num, i);
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int another = target - num;
            Integer index = map.get(another);
            if (index != null && i != index) {
                return new int[]{i, index};
            }
        }

        return new int[0];
    }

    public static int fourSum_LC454(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int value1 = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                int value2 = nums2[j] + value1;
                map.put(value2, map.getOrDefault(value2, 0) + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < nums3.length; i++) {
            int val3 = nums3[i];
            for (int j = 0; j < nums4.length; j++) {
                int val4 = 0 - nums4[j] - val3;
                res += map.getOrDefault(val4, 0);
            }
        }

        return res;
    }

    public static boolean canConstruct_LC383(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] chars = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int index = c - 'a';
            chars[index] += 1;
        }

        for (int i = 0; i < magazine.length(); i++) {
            char d = magazine.charAt(i);
            int index = d - 'a';
            if (chars[index] == 0) {
                continue;
            }
            chars[index] -= 1;
        }

        for (int c : chars) {
            if (c > 0) {
                return false;
            }
        }

        return true;
    }

    public static List<List<Integer>> threeSum_LC15(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num > 0) {
                return result;
            }

            // remove duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum + num == 0) {
                    result.add(Arrays.asList(num, nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                    right--;
                    left++;
                } else if (sum + num > 0) {
                    right--;
                } else if (sum + num < 0) {
                    left++;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> fourSum_LC18(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];

            if (nums[i] > 0 && nums[i] > target) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                long firstTwoSum = (long) a + b;

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[left] + nums[right];
                    if (sum + firstTwoSum == target) {
                        result.add(Arrays.asList(a,b, nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        right--;
                        left++;
                    } else if (sum + firstTwoSum > target) {
                        right--;
                    } else if (sum + firstTwoSum < target) {
                        left++;
                    }
                }

            }
        }

        return result;
    }
}
