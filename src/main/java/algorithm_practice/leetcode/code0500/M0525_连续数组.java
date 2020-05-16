package algorithm_practice.leetcode.code0500;

import java.util.HashMap;

/**
 * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 * <p>
 * 输入: [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *  
 * 0 1 1 1 1 0 0
 * -1,0,1,2,3,2,1
 * 0,1,2,3,4,3,2
 * <p>
 * 0 1 0
 * -1,0,-1
 * <p>
 * 1 1 1 0 0 0
 * 1 2 3 2 1 0
 * 注意: 给定的二进制数组的长度不会超过50000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0525_连续数组 {
//    public int findMaxLengthViolence(int[] nums) {
//        int ans = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int[] memo = new int[2];
//            for (int j = i; j < nums.length; j++) {
//                memo[nums[j]]++;
//                if (memo[0] == memo[1])
//                    ans = Math.max(ans, 2 * memo[0]);
//            }
//        }
//        return ans;
//    }

    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int ans = -1;
        int count = 0;
        hashMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] == 0) ? -1 : 1;
            if (hashMap.containsKey(count)) {
                ans = Math.max(ans, i - hashMap.get(count));
            } else {
                hashMap.put(count, i);
            }
        }
        return ans;
    }
}
