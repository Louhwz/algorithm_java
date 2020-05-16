package algorithm_practice.leetcode.code0100;

import common.datastructure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class M0143_重排链表 {
    public void reorderList(ListNode head) {
        if (head == null)
            return;
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode p = head;
        while (p != null) {
            deque.addLast(p);
            p = p.next;
        }
        int c = 0;
        p = head;
        deque.removeFirst();
        p.next = null;
        c++;
        while (!deque.isEmpty()) {
            ListNode tmp = null;
            if (c % 2 == 1) {
                tmp = deque.removeLast();
            } else {
                tmp = deque.removeFirst();
            }
            c++;
            c %= 2;
            tmp.next = null;
            p.next = tmp;
            p = p.next;
        }
    }
}
