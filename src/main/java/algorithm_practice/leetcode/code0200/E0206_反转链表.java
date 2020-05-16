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
/*        if (head == null) {
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
        return pre;*/
        ListNode pre = null;
        ListNode after = head;
        //三个指针，pre，head，after
        //after初值指向head，在循环里head指向after，对after做判断，after首先赋值head.next
        //反转，pre指向head
        while(after!=null){
            head = after;
            after = head.next;
            head.next = pre;
            pre = head;
        }
        return head;
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
