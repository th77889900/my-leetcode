package com.leetcode.study.codecaprice.linklist.dualpointers;

import com.leetcode.study.codecaprice.linklist.ListNode;

/**
 *
 * @author : Cody
 * @date : 2023-06-18 8:01 p.m.
 */
public class BottomToK_LC19 {


    public ListNode removeFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode node = findFromBottom(dummy, n + 1);

        node.next = node.next.next;

        return head;
    }

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
