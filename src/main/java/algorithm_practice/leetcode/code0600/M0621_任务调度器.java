package algorithm_practice.leetcode.code0600;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * <p>
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * <p>
 * 你需要计算完成所有任务所需要的最短时间。
 * <p>
 *  
 * <p>
 * 示例 ：
 * <p>
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 * 在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/task-scheduler
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0621_任务调度器 {

    class timer {
        public int limitTime = 0;
        public int freq;

        public timer(int freq) {
            this.freq = freq;
        }

    }

    public int leastInterval(char[] tasks, int n) {
        int[] hash = new int[26];
        for (char c : tasks) {
            hash[(int) c - 'A']++;
        }
        PriorityQueue<timer> pq = new PriorityQueue<>(new Comparator<timer>() {
            @Override
            public int compare(timer o1, timer o2) {
                return o2.freq - o1.freq;
            }
        });
        for (int k : hash) {
            if (k != 0)
                pq.add(new timer(k));
        }
        int time = 0;
        while (!pq.isEmpty()) {
            //选择任务执行，没有任务就空过
            //优先选择freq次数多的和time小的
            //最优先选择time>=limitTime的
            for (timer t : pq) {
                if (time >= t.limitTime) {
                    t.limitTime = t.limitTime + n + 1;
                    t.freq--;

                }
            }

            time++;
        }
        return time;
    }

    @Test
    public void test() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 10; i >= 0; i--) {
            pq.add(i);
        }
        for (Integer integer : pq) {
            System.out.println(integer);
        }
//        leastInterval(new char[]{'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'C', 'C'}, 3);
    }
}
