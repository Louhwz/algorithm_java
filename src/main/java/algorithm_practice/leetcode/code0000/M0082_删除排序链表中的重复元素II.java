package algorithm_practice.leetcode.code0000;

import common.datastructure.ListNode;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0082_删除排序链表中的重复元素II {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode q = node, p = head;
        while (p != null) {
            if (p.next != null && p.val == p.next.val) {
                int k = p.val;
                while (p != null && p.val == k) {
                    p = p.next;
                }
                if (p == null || p.next == null || p.val != p.next.val) {
                    q.next = p;
                    q = p;
                }
            } else {
                q = p;
                p = p.next;
            }
        }
        return node.next;
    }

    public ListNode deleteDuplicatesRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        if (cur.val != head.val) {
            head.next = deleteDuplicatesRecursion(cur);
        } else {
            while (cur != null && cur.val == head.val) {
                cur = cur.next;
            }
            head = deleteDuplicatesRecursion(cur);
        }
        return head;
    }
}
