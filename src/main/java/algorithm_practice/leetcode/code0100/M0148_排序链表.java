package algorithm_practice.leetcode.code0100;

import common.datastructure.ListNode;
import org.junit.Test;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0148_排序链表 {
    public ListNode sortList(ListNode head) {
        ListNode k = head.next;
        while (k != null) {
            ListNode tp = k, tpans = k;
            int ans = tp.val;
            while (tp != null) {
                if (tp.val < ans) {
                    ans = tp.val;
                    tpans = tp;
                }
                tp = tp.next;
            }
            int tmp = tpans.val;
            tpans.val = k.val;
            k.val = tmp;

            k = k.next;

        }
        return head;
//        ListNode end = head;
//        while (end.next != null) {
//            end = end.next;
//        }
//        quick_sort_c(head, end);
//        return head;
    }

    private void quick_sort_c(ListNode head, ListNode end) {
        if (end == head)
            return;

    }

    @Test
    public void test() {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 1 + 'a').append("\n\t").append("append char(1):").append((char) 2 * 49);
        System.out.println(sb.toString());
        System.out.println((int) 'a');
        System.out.println(1 + 'a');
        System.out.println('a' * 2);
    }
}
