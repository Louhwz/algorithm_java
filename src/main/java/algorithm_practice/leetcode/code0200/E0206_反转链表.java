package algorithm_practice.leetcode.code0200;

import common.datastructure.ListNode;
import org.junit.Test;

import java.util.List;

public class E0206_反转链表 {
    @Test
    public void testGrammar() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        reverseList(head);
    }


    public ListNode reverseListNoRecursion(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head, curr = head.next;
        pre.next = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return curr;
    }
}
