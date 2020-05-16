package algorithm_practice.leetcode.code0500;

import java.util.HashMap;

/**
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 * <p>
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 * 说明: 输入的数组长度最大不超过20,000.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-harmonious-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E0594_最长和谐子序列 {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int k : nums) {
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        int ans = 0;
        for (Integer integer : map.keySet()) {
            if (map.containsKey(integer + 1)) {
                ans = Math.max(ans, map.get(integer) + map.get(integer + 1));

            }

        }
        return ans;
    }
}
