package com.leetcode.study.labuladong.linklist.palindrome;

import com.leetcode.study.labuladong.linklist.ListNode;

/**
 * 而判断一个字符串是不是回文串就简单很多，
 * 不需要考虑奇偶情况，只需要双指针技巧，从两端向中间逼近即可
 * @author : Cody.Teng
 * @date : 2023-07-10 12:09 p.m.
 */
public class Palindrome {

    public boolean isStrPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }

        int left = 0;
        int right = s.length();
        char[] chars = s.toCharArray();
        while (left <= right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private ListNode left;

    /**
     * 现将链表反转 然后再比较
     *
     * @param head
     * @return
     */
    public boolean isListPalindrome(ListNode head) {
        left = head;

        return traverse(head);
    }

    private boolean traverse(ListNode right) {
        if (right == null) {
            return true;
        }

        boolean boo = traverse(right.next);

        boo = boo && (left.val == right.val);

        left = left.next;

        return boo;
    }

}
