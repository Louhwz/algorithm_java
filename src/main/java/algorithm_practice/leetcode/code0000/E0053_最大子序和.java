package algorithm_practice.leetcode.code0000;

public class E0053_最大子序和 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = nums[0];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
