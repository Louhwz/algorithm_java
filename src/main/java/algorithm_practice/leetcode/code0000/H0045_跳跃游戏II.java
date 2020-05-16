package algorithm_practice.leetcode.code0000;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class H0045_跳跃游戏II {

    int[] dp;
    int[] nums;

    private int backtrack(int start) {
        if (start >= nums.length - 1) {
            return 0;
        }
        if (dp[start] != Integer.MAX_VALUE)
            return dp[start];
        if (nums[start] == 0)
            return Integer.MAX_VALUE;
        for (int i = 1; i <= nums[start]; i++) {
            int k = backtrack(i + start);
            if (k == Integer.MAX_VALUE)
                continue;
            dp[start] = Math.min(dp[start], 1 + k);
        }
        return dp[start];
    }

    public int jump(int[] nums) {
        this.nums = nums;
        dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[nums.length - 1] = 0;
        //recall(nums.length - 1, 0);
        backtrack(0);
        return dp[0];
    }

    @Test
    public void test() {
        TestCase.assertEquals(2, jump(new int[]{1, 1, 1}));
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{2, 1, 3, 1, 1, 2, 1, 1}));
        System.out.println(jump(new int[]{2, 3, 0, 1, 4}));


    }
}
