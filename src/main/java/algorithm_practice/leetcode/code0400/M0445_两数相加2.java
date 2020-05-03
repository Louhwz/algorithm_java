package algorithm_practice.leetcode.code0400;

import common.datastructure.ListNode;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0445_两数相加2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode l1t = new ListNode(0), l2t = new ListNode(0);
        while (l1 != null) {
            ListNode temp = l1.next;
            l1.next = l1t.next;
            l1t.next = l1;
            l1 = temp;
        }
        while (l2 != null) {
            ListNode temp = l2.next;
            l2.next = l2t.next;
            l2t.next = l2;
            l2 = temp;
        }
        int carry = 0;
        ListNode k1 = l1t.next, k2 = l2t.next;
        /**
         * 这里可以简化写法，用一个temp变量先后+carry+k1.val+k2.val，k1.val和k2.val相加之前都要做
         * 链表非空判断，也可以用栈简化写法。
         */
        while (k1 != null && k2 != null) {
            int tempsum = k1.val + k2.val + carry;
            carry = tempsum / 10;
            ListNode temp = new ListNode(tempsum % 10);
            temp.next = res.next;
            res.next = temp;
            k1 = k1.next;
            k2 = k2.next;
        }
        while (k1 != null) {
            int tempsum = k1.val + carry;
            carry = tempsum / 10;
            ListNode temp = new ListNode(tempsum % 10);
            temp.next = res.next;
            res.next = temp;
            k1 = k1.next;

        }
        while (k2 != null) {
            int tempsum = k2.val + carry;
            carry = tempsum / 10;
            ListNode temp = new ListNode(tempsum % 10);
            temp.next = res.next;
            res.next = temp;
            k2 = k2.next;
        }
        if (carry != 0) {
            ListNode temp = new ListNode(1);
            temp.next = res.next;
            res.next = temp;
        }
        return res.next;
    }
}
