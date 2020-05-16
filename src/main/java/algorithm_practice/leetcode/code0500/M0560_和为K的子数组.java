package algorithm_practice.leetcode.code0500;

import java.util.HashMap;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * <p>
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0560_和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        //1 1 1 -1 1 1
        //2
        //1 2 3 2 3 4
        //1 1 1 1 -1 -1 1 1 1 1
        //1 2 3 4 3  2  3 4 5 6
        //sum(i,j) = sum(0,j)-sum(0,i)
        //sum from index i to j-1
        int ans = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k)
                ans++;
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;

/*        int ans =0;
        long[] sum = new long[nums.length];
        sum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            sum[i] = nums[i]+sum[i-1];
        }
        for(int i=0;i<nums.length;i++){
            if(sum[i]==k)
                ans++;
            for(int j=0;j<i;j++){
                if((int)(sum[i] - sum[j]) ==k ){
                    ans++;
                }
            }
        }
        return ans;*/


    }
}
