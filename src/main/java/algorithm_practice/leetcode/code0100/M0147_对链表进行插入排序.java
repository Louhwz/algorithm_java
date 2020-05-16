package algorithm_practice.leetcode.code0100;

import common.datastructure.ListNode;
import org.junit.Test;

public class M0147_对链表进行插入排序 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;

        ListNode guard = new ListNode(0);
        guard.next = head;
        ListNode k = head;
        k = k.next;
        head.next = null;
        while (k != null) {
            ListNode next = k.next;
            int val = k.val;
            ListNode c = guard;
            while (c.next != null && c.next.val <= val) {
                c = c.next;
            }
            if (c.next == null) {
                c.next = k;
                k.next = null;
            } else {
                k.next = c.next;
                c.next = k;
            }
            k = next;
        }
        return guard.next;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        insertionSortList(head);
        System.out.println(head.val);
    }
}
