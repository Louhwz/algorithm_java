package algorithm_practice.leetcode.code0300;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0322_零钱兑换 {

    @Test
    public void test0322() {
        System.out.println(coinChange(new int[]{186, 419, 83, 408}, 6249));
    }

    //5,6    15
    //3,5,6  15
    //5,6,20 15
    //1,5,6  35
    //[186,419,83,408]
    //6249

    private int minNum = Integer.MAX_VALUE;

    private void opCoin(int[] coins, int amount, int index, int size) {
        //amount减完
        if (amount == 0) {
            minNum = Math.min(size, minNum);
        }
        if (amount < 0 || index < 0) {
            return;
        }
        int counter = amount / coins[index];
        //
        for (int i = counter; i >= 0 && size + i < minNum; i--) {
            opCoin(coins, amount - i * coins[index], index - 1, size + i);
        }


    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        opCoin(coins, amount, coins.length - 1, 0);

        return minNum == Integer.MAX_VALUE ? -1 : minNum;
    }
}
