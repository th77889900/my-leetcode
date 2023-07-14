package com.leetcode.study.labuladong.linklist.recursivemagic;

import com.leetcode.study.labuladong.linklist.ListNode;


/**
 * reverse all the list
 *
 * @author : Cody.Teng
 * @date : 2023-07-08 7:11 p.m.
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode reverseHead = reverse_LC26(head);

        System.out.println(reverseHead.val);

    }

    /**
     * reverse all list
     * @param head
     * @return
     */
    public static ListNode reverse_LC26(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverse_LC26(head.next);

        head.next.next = head;
        head.next = null;

        return last;
    }

    ListNode successor = null;

    public ListNode reverseN(ListNode head, int n) {

        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public ListNode reversePart(ListNode head, int star, int end) {

        if (star == 1) {
            return reverseN(head, end);
        }

        head.next = reversePart(head.next, star - 1, end - 1);

        return head;
    }

}
