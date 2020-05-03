package algorithm_practice.leetcode.code0000;

import common.datastructure.ListNode;
import org.junit.Test;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class H0023_合并K个排序链表 {

    @Test
    public void test() {
        ListNode k1 = null;
        ListNode k2 = new ListNode(new int[]{-1, 5, 11});
        ListNode k3 = null;
        ListNode k4 = new ListNode(new int[]{6, 10});
        ListNode res = mergeKLists(new ListNode[]{k1, k2, k3, k4});
        System.out.println(3);
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        ListNode head = new ListNode(0);
        ListNode k = head;
        while (a != null && b != null) {
            k.next = a.val <= b.val ? a : b;
            k = k.next;
            if (a.val <= b.val) {
                a = a.next;
            } else {
                b = b.next;
            }
        }
        if (a != null) {
            k.next = a;
        }
        if (b != null) {
            k.next = b;
        }
        return head.next;
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = l + ((r - l) >> 1);
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }
}
