package algorithm_practice.leetcode.code0200;

import common.datastructure.ListNode;

public class E0234_回文链表 {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return false;
        ListNode fast = head.next, slow = head;
        if (fast == null)
            return true;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            ListNode tmp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = tmp;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            } else {
                break;
            }
        }
        if (fast == null) {
            fast = slow;
        } else {
            fast = slow.next;
        }
        //1 2 3 4
        //
        while (slow != null) {
            if (slow.val != fast.val)
                return false;
            slow = slow.next;

        }
        return true;
    }
}
