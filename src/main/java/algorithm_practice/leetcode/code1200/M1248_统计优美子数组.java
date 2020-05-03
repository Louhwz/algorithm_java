package algorithm_practice.leetcode.code1200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums 和一个整数 k。
 * <p>
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * <p>
 * 请返回这个数组中「优美子数组」的数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 * <p>
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1248_统计优美子数组 {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> odd = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                odd.add(i);
            }
        }
        int opt = 0;

        for (int i = 0; i <= odd.size() - k; i++) {
            //55 56 length = 57
            //2 2 2 1 2  k = 1
            //rei = 1  rsi = 0
            //4  3
            int rightEndIndex = i + k;//右括号
            int rightStartIndex = i + k - 1;
            int rightEnd = rightEndIndex < odd.size() ? odd.get(rightEndIndex) - 1 : nums.length - 1;
            int rightStart = odd.get(rightStartIndex);

            int leftStartIndex = i - 1;
            int leftStart = leftStartIndex < 0 ? 0 : odd.get(leftStartIndex) + 1;
            int leftEndIndex = i;
            int leftEnd = odd.get(leftEndIndex);
            opt += (leftEnd - leftStart + 1) * (rightEnd - rightStart + 1);
        }
        return opt;
    }


    public int numberOfSubarraysFirst(int[] nums, int k) {
        int opt = 0;
        int[][] dp = new int[nums.length][nums.length];

        for (int i = k; i <= nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                if (i == k && j == 0) {
                    int tmp = 0;
                    for (int t = 0; t < i; t++) {
                        if (nums[t] % 2 == 1)
                            tmp++;
                    }
                    dp[0][k - 1] = tmp;
                    if (dp[j][j + k - 1] == k) {
                        opt++;
                    }
                    continue;
                }
                if (j == 0) {
                    if (nums[i] % 2 == 1) {
                        dp[0][i] = dp[0][i - 1] + 1;
                    }
                } else {
                    int tmp = dp[j - 1][j + i - 2];
                    if (nums[j - 1] % 2 == 1) {
                        tmp--;
                    }
                    if (nums[j + i - 1] % 2 == 1) {
                        tmp++;
                    }
                    dp[j][j + i - 1] = tmp;
                }
                if (dp[j][j + i - 1] == k) {
                    opt++;
                }
            }
        }
        return opt;
    }


    public int numberOfSubarraysTLE(int[] nums, int k) {
        int opt = 0;
        //int[][] dp = new int[nums.length][nums.length];

/*        for (int span = k; span <= nums.length; span++) {
            for (int start = 0; start <= nums.length - span; start++) {
                //启动
                //[start, start+k-1]
                if (span == k && start == 0) {
                    for (int i = start; i <= start + k - 1; i++) {
                        if (nums[i] % 2 == 1) {
                            dp[0][k - 1] += 1;
                        }
                    }
                    if (dp[0][k - 1] == k) {
                        opt++;
                    }
                    continue;
                }
                if (start == 0) {
                    dp[0][span - 1] = (nums[span - 1] % 2 == 1) ? dp[0][span - 2] + 1 : dp[0][span - 2];
                    if (dp[start][start + span - 1] == k) {
                        opt++;
                    }
                    continue;
                }
                dp[start][start + span - 1] = dp[start - 1][start + span - 2];
                if (nums[start - 1] % 2 == 1) {
                    dp[start][start + span - 1] -= 1;
                }
                if (nums[start + span - 1] % 2 == 1) {
                    dp[start][start + span - 1] += 1;
                }
                if (dp[start][start + span - 1] == k) {
                    opt++;
                }
            }
        }*/
        int[] dp = new int[nums.length];
        int last0 = 0;
        for (int span = k; span <= nums.length; span++) {
            for (int start = 0; start <= nums.length - span; start++) {
                //启动
                //[start, start+k-1]
                if (span == k && start == 0) {
                    for (int i = start; i <= start + k - 1; i++) {
                        if (nums[i] % 2 == 1) {
                            dp[k - 1] += 1;
                        }
                    }
                    if (dp[k - 1] == k) {
                        opt++;
                    }
                    last0 = dp[k - 1];
                    continue;
                }
                if (start == 0) {
                    dp[span - 1] = (nums[span - 1] % 2 == 1) ? last0 + 1 : last0;
                    if (dp[start + span - 1] == k) {
                        opt++;
                    }
                    last0 = dp[span - 1];
                    continue;
                }
                dp[start + span - 1] = dp[start + span - 2];
                if (nums[start - 1] % 2 == 1) {
                    dp[start + span - 1] -= 1;
                }
                if (nums[start + span - 1] % 2 == 1) {
                    dp[start + span - 1] += 1;
                }
                if (dp[start + span - 1] == k) {
                    opt++;
                }
            }
        }
        return opt;
    }

    @Test
    public void test1248() {
        int[] c = new int[]{2, 1, 2, 1, 2};
        numberOfSubarrays(c, 2);
    }
}
