package algorithm_practice.leetcode.code0200;

import org.junit.Test;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * <p>
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E0202_快乐数 {
    private int SumOfSquares(int n) {
        int k = 0;
        while (n != 0) {
            int s = n % 10;
            k += s * s;
            n /= 10;
        }
        return k;
    }

    public boolean isHappy(int n) {
        int pre = n, fo = n;
        boolean fir = true;
        while(!(fo==1 || (!fir && pre==fo))){
            if (fir)
                fir = false;
            pre = SumOfSquares(pre);
            fo = SumOfSquares(SumOfSquares(fo));
        }
        return fo == 1;
    }


    public boolean isHappyMine(int n) {
        if (n == 0) return false;
        int counter = 0;
        while (n != 1 && counter < 10000) {
            n = SumOfSquares(n);
            counter++;
        }
        if (n == 1)
            return true;
        else
            return false;
    }

    @Test
    public void test() {
        isHappy(2);
    }
}

