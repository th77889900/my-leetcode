package com.leetcode.study.labuladong.linklist.dualpointers;

import com.leetcode.study.labuladong.linklist.ListNode;

/**
 * @author : Cody
 * @date : 2023-06-11 9:57 a.m.
 */
public class PartitionList_LC86 {

    /*
        head =[1,4,3,0,2,5,2]
        x = 3
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(2);
        ListNode p = partition(head, 3);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {

        if(head==null) {
            return head;
        }

        ListNode p1 = head;

        // First find the fist node which is greater than or equal to the given value
        while (p1.next != null) {
            if (head.val >= x) {
                break;
            }
            if (p1.next.val >= x) {
                break;
            }else {
                p1 = p1.next;
            }

            if (p1.next == null) {
                return head;
            }
        }

        ListNode p2 = p1;

        while (p2 != null && p2.next != null) {

            if (p2.next.val < x) {
                ListNode tmp = p2.next;
                p2.next = tmp.next;
                //Check if p1 is the head node
                if (p1 == head && head.val >= x) {
                    tmp.next = p1;
                    p1 = tmp;
                    head = p1;
                } else {
                    tmp.next = p1.next;
                    p1.next = tmp;
                    p1 = tmp;
                }
            }else {
                p2 = p2.next;
            }

        }

        return head;

    }

}
