package com.leetcode.study.labuladong.linklist.dualpointers;

import com.leetcode.study.labuladong.linklist.ListNode;

/**
 * @author : Cody.Teng
 * @date : 2023-07-07 10:49 p.m.
 * find the middle node of single list
 * Approach to Problem-Solving: use two points, one point is fast and another is slow.
 * the fast point step two and the slow point step one, so when the fast get to end and
 * the slow point get to the middle.
 */
public class MiddleList_LC876 {


    public ListNode middleNode(ListNode head) {
        // define two point one being a fast pointer and the other being slow pointer
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
