package algorithm_practice.leetcode.code0200;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * 使用栈实现队列的下列操作：
 * <p>
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 示例:
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * 说明:
 * <p>
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 */
public class MyQueue {

    private Stack<Integer> sPush = new Stack<>();
    private Stack<Integer> sDump = new Stack<>();

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {

        sPush.push(x);
    }

    private void Dump() {
        if (sDump.isEmpty()) {
            while (!sPush.isEmpty()) {
                sDump.push(sPush.pop());
            }
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        Dump();
        return sDump.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        Dump();

        return sDump.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return sPush.isEmpty() && sDump.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.peek();
        int param_3 = obj.pop();
        boolean param_4 = obj.empty();
    }
}
