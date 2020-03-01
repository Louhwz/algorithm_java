package algorithm_practice.leetcode.code0200;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class E0225_用队列实现栈 {

    @Test
    public void testGrammar() {
        E0225_用队列实现栈 cc = new E0225_用队列实现栈();
        cc.push(1);
        cc.push(2);
        System.out.println(cc.top());
        System.out.println(cc.pop());
        System.out.println(cc.empty());
    }

    Queue<Integer> q, p;

    /**
     * Initialize your data structure here.
     */
    public E0225_用队列实现栈() {
        q = new LinkedList<Integer>();
        p = new LinkedList<Integer>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int k = 0;

        while (q.size() > 1) {
            p.add(q.remove());
        }
        k = q.poll();

        Queue<Integer> temp = q;
        q = p;
        p = temp;

        return k;
    }

    /**
     * Get the top element.
     */
    public int top() {
        int k = 0;

        while (!q.isEmpty()) {
            k = q.poll();
            p.add(k);
        }

        Queue<Integer> temp = q;
        q = p;
        p = temp;
        return k;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q.isEmpty() && p.isEmpty();
    }
}
