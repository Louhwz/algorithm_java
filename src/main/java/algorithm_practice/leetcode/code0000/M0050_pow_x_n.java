package algorithm_practice.leetcode.code0000;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class M0050_pow_x_n {

    Map<Long, Double> map = new HashMap<>();

    private double recursion(double x, long ln) {
        if (ln == 1)
            return x;
        if (ln == 0)
            return 1;
        if (map.containsKey(ln))
            return map.get(ln);
        if (ln % 2 == 0) {
            double a = recursion(x, ln / 2);
            map.put(ln, a * a);
            return a * a;
        } else {
            double a = recursion(x, ln / 2);
            double b = recursion(x, ln / 2 + 1);
            map.put(ln, a * b);
            return a * b;
        }
    }

    public double myPow(double x, int n) {
        double res = recursion(x, Math.abs((long) n));
        return n < 0 ? 1 / res : res;
    }
}
