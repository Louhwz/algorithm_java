package algorithm_practice.leetcode.code0000;

import common.datastructure.ListNode;
import org.junit.Test;

import java.util.List;

/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class H0025_K个一组翻转链表 {


    public ListNode reverseKGroup(ListNode head, int k) {
        int counter = 0;
        ListNode p = head;
        while (p != null) {
            counter++;
            p = p.next;
        }
        ListNode guard = new ListNode(0);
        guard.next = head;
        ListNode pre = guard;
        while (counter != 0) {
            if (counter >= k) {
                ListNode kgroupfirst = head;
                ListNode tpPre = null, tpAfter = head.next;
                for (int i = 0; i < k; i++) {
                    tpAfter = head.next;
                    head.next = tpPre;
                    tpPre = head;
                    head = tpAfter;
                }
                kgroupfirst.next = head;
                pre.next = tpPre;
                pre = kgroupfirst;
                counter -= k;
            } else {
                pre.next = head;
                counter = 0;
            }
        }
        return guard.next;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        testcallParameters(head);
        if (head == null)
            System.out.println("yes!you are right");
        else {
            System.out.println(head.val);
        }
    }

    private void testcallParameters(ListNode head) {
        while (head != null)
            head = head.next;
    }
}
