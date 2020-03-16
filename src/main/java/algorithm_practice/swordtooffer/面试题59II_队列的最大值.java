package algorithm_practice.swordtooffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 * <p>
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 面试题59II_队列的最大值 {

    private Queue<Integer> queue = null;
    private Deque<Integer> max_queue = null;

    //3 2 9 10 1 7
    public 面试题59II_队列的最大值() {
        queue = new ArrayDeque<>();
        max_queue = new ArrayDeque<>();
    }

    public int max_value() {
        return max_queue.isEmpty() ? -1 : max_queue.getFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while (!max_queue.isEmpty() && value > max_queue.getLast()) {
            max_queue.removeLast();
        }
        max_queue.addLast(value);

    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int k = queue.poll();
        if (k == max_queue.getFirst()) {
            max_queue.pollFirst();
        }
        return k;
    }
}
