package algorithm_practice.leetcode.code0000;

import common.datastructure.ListNode;
import org.junit.Test;

public class M0086_分割链表 {


    public ListNode partition(ListNode head, int x) {
        ListNode dummyA = new ListNode(0), dummyB = new ListNode(0), a = dummyA, b = dummyB, p;
        p = head;
        while (p != null) {
            if (p.val < x) {
                a.next = new ListNode(p.val);
                a = a.next;
            } else {
                b.next = new ListNode(p.val);
                b = b.next;
            }
            p = p.next;
        }
        a.next = dummyB.next;
        return dummyA.next;

    }
}
