package algorithm_practice.leetcode.code0400;

import org.junit.Test;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * <p>
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * 一共有5种方法让最终目标和为3。
 * 注意:
 * <p>
 * 数组非空，且长度不会超过20。
 * 初始的数组的和不会超过1000。
 * 保证返回的最终结果能被32位整数存下。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0494_目标和 {
    private int[] nums;
    private int S;
    private int res = 0;

    private void recursion(int start, int sum) {
        if (start == nums.length && sum == S) {
            res++;
            return;
        }
        if (start >= nums.length)
            return;
//        for (int i = start; i < nums.length; i++) {
        for (int j = 0; j < 2; j++) {
            if (j == 0) {
                recursion(start + 1, sum + nums[start]);
            } else {
                recursion(start + 1, sum - nums[start]);
            }
        }
//        }
    }

    public int findTargetSumWayspow2_n(int[] nums, int S) {
        this.nums = nums;
        this.S = S;
        recursion(0, 0);
        return this.res;
    }

    public int findTargetSumWays(int[] nums, int S) {
        //前i个数（从0开始）组成和为j的方案个数
        //dp[i][j] = dp[i-1][j-nums[i]]+dp[i-1][j+nums[i]]
        //dp[0][1]=1,dp[0][-1]=1
        //dp[1][2]=1,dp[1][-2]=1
        //dp[1][0]=1 dp[1][0]=2
        //dp[2][3]=1,dp[2][1]=1,dp[2][-3]=1,dp[2][-1]=1
        //dp[2][1]=3,dp[2][-1]=3
        //【-1000，1000】
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][1000 - nums[0]] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = -1000; j <= 1000; j++) {
                if (dp[i - 1][j + 1000] != 0) {
                    dp[i][j + nums[i] + 1000] += dp[i - 1][j + 1000];
                    dp[i][j - nums[i] + 1000] += dp[i - 1][j + 1000];
                }
            }
        }
        if (S <= -1000 || S >= 1000) {
            return 0;
        }
        return dp[nums.length - 1][S + 1000];
    }

    @Test
    public void test() {
        //System.out.println(findTargetSumWays(new int[]{1, 1}, 0));
        System.out.println(findTargetSumWays(new int[]{1, 1, 1}, 1));
    }
}
