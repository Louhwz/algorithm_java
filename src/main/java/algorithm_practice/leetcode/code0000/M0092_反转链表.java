package algorithm_practice.leetcode.code0000;

import common.datastructure.ListNode;
import org.junit.Test;

import java.util.List;

public class M0092_反转链表 {

    @Test
    public void test0092() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        reverseBetween(head, 2, 3);
    }

    /**
     * 注意，以下索引位置从1开始计数
     * 1、在链表中找到l[m],记录l[m-1],l[m]
     * 2、开始遍历链表
     * 遍历过程中翻转链表，除非当前待遍历的节点是l[m]
     * 遍历直到l[n]，同时用一个多余的变量记录l[n+1]
     * l[n]不会是null，但l[n+1]可能是null
     * 3、进行后续处理，l[m-1]指向l[n],l[m]指向l[n+1]
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetweenNoRecursion(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        if (m == n) {
            return head;
        }
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode m_1 = node, p = head, pp = p, nodeM = head;
        int counter = 1;
        while (counter < m) {
            m_1 = p;
            p = p.next;
            counter++;
        }
        nodeM = p;
        pp = m_1;

        while (counter <= n) {
            ListNode temp = p.next;
            p.next = pp;
            pp = p;
            p = temp;

            counter++;
        }

        nodeM.next = p;
        m_1.next = pp;
        return node.next;
    }

    /**
     * 其实可以在遍历的时候连接l[m-1]和l[n]，最后再做将l[m]指向l[n+1]的动作
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode node = new ListNode(0);
        node.next = head;
        ListNode nodem_1 = node;
        int counter = 0;
        while (counter < m - 1) {
            nodem_1 = nodem_1.next;
            counter++;
        }
        reverseBetweenRecursion(node, m, n, 0, nodem_1);
        return node.next;
    }

    //1 2 3 4 5 m=1,n=3
    //3 2 1 4 5
    private ListNode reverseBetweenRecursion(ListNode head, int m, int n, int counter, ListNode nodem_1) {
        if (counter == n) {
            nodem_1.next = head;
            return head.next;

        }

        ListNode curr = reverseBetweenRecursion(head.next, m, n, counter + 1, nodem_1);


        if (counter >= m) {
            head.next.next = head;
            head.next = curr;
        }
        return curr;
    }

    private ListNode successor = null;

    /*
    在这里清晰的定义语义：从head节点开始反转链表，返回新链表的头节点
     */
    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public ListNode reverseBetweenlabuladong(ListNode head, int m, int n) {
        /*
        base case
         */
        if (m == 1) {
            return reverseN(head, n);
        }
        reverseBetweenlabuladong(head.next, m - 1, n - 1);
        return head;
    }
}
