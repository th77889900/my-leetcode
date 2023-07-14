package com.leetcode.study.labuladong.linklist.dualpointers;

import com.leetcode.study.labuladong.linklist.ListNode;

/**
 * @author : Cody.Teng
 * @date : 2023-07-08 1:42 p.m.
 * Approach to determine if two linked lists intersect:
 *      Connect the head and tail of the two linked lists together.
 *      If they intersect, it will form a loop. This allows us to use
 *      the method of checking for the presence of a loop in a linked list
 *      and finding the intersection point to identify the common intersection point.
 *      If there is no loop, it indicates that the two linked lists do not intersect.
 * Approach to determine if two linked lists intersect-2:
 *      将两个链表分别链接在一起 如果可以有相同的节点 说明 相交 并且返回公共的相交点
 */
public class InterestList_LC160 {

    public ListNode checkIntersection(ListNode head1, ListNode head2) {

        ListNode p1 = head1;
        ListNode p2 = head2;

        int count = 0;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = head2;
                ++count;
                if (count == 2) {
                    return null;
                }
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = head1;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }

}
