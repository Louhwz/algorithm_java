package algorithm_practice.swordtooffer;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 *  5%3 = 2
 * 2+
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 * <p>
 * 输入: n = 10, m = 17
 * 输出: 2
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 */
public class 面试题62_圆圈中最后剩下的数字 {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        int idx = 0;
        while (arrayList.size() > 1) {
            int delIndex = (idx + m - 1) % arrayList.size();
            arrayList.remove(delIndex);
            idx = delIndex;
        }

        return arrayList.get(0);
    }

    @Test
    public void test62() {
        System.out.println(lastRemaining(5, 3));
    }
}
