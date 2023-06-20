package com.leetcode.study.labuladong.linklist.dualpointers;

import com.leetcode.study.labuladong.linklist.ListNode;

/**
 *
 * @author : Cody
 * @date : 2023-06-18 8:01 p.m.
 */
public class BottomToK {

    public ListNode findFromBottom(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode p1 = head;

        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        ListNode p2 = head;

        while (p1.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }

}
