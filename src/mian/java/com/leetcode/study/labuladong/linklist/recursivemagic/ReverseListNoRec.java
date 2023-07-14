package com.leetcode.study.labuladong.linklist.recursivemagic;

import com.leetcode.study.labuladong.linklist.ListNode;

/**
 * Use no recursion to impl list reverse
 *
 * @author : Cody.Teng
 * @date : 2023-07-08 9:58 p.m.
 */
public class ReverseListNoRec {

    public ListNode reverseAllList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre, cur, nxt;
        pre = null; cur = head; nxt = head;
        while (cur != null) {
            nxt = cur.next;
            // 逐个结点反转
            cur.next = pre;
            // 更新指针位置
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

    /**
     * reverse head to b node
     * @param head
     * @param b
     * @return
     */
    public ListNode reverseB(ListNode head, ListNode b) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre, cur, nxt;
        pre = null; cur = head; nxt = head;
        while (cur != b) {
            nxt = cur.next;
            // 逐个结点反转
            cur.next = pre;
            // 更新指针位置
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

    /**
     * reverse head to b node
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup_LC25(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode a, b;
        a = b = head;

        for (int i = 0; i < k; i++) {
            if (b == null) {
                return b;
            }
            b = b.next;
        }

        ListNode newHead = reverseB(a, b);

        a.next = reverseKGroup_LC25(b, k);

        return newHead;
    }

}
