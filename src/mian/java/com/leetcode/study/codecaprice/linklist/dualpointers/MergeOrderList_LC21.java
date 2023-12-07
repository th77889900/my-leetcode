package com.leetcode.study.codecaprice.linklist.dualpointers;

import com.leetcode.study.codecaprice.linklist.ListNode;

/**
 * @author : Cody
 * @date : 2023-06-10 10:17 p.m.
 */
public class MergeOrderList_LC21 {

    public static ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode node = new ListNode(-1);
        ListNode p = node;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            }else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return node.next;
    }

}
