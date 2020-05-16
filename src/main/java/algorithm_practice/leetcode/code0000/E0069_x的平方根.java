package algorithm_practice.leetcode.code0000;

import org.junit.Assert;
import org.junit.Test;

/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E0069_x的平方根 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        int left = 1, right = x / 2;
        long tp = 0, tp2 = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            tp = (long) mid * mid;
            tp2 = (long) (mid + 1) * (mid + 1);
            if (tp == x)

                return mid;
            if (tp < x && tp2 > x)
                return mid;
            if (tp < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;

    }

    @Test
    public void test() {
        Assert.assertEquals(46339, mySqrt(2147395599));
    }
}
