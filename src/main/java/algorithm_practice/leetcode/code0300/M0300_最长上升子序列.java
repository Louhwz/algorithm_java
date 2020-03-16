package algorithm_practice.leetcode.code0300;


import org.junit.Test;

public class M0300_最长上升子序列 {

    @Test
    public void test0300() {
        //    System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 1, 21, 18}));
        //System.out.println(lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
        System.out.println(lengthOfLIS(new int[]{9, 8, 7}));
    }

    public int lengthOfLISON2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            int mm = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    mm = Math.max(mm, dp[j]);
                }
            }
            dp[i] = mm + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * O(nlogn)，维护一个tails数组，表示长度为i的最长子序列的最小尾部元素
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length + 1];
        int index = 0;
        tails[0] = Integer.MIN_VALUE;
        for (int num : nums) {
            //包含了一个冷启动
            if (num > tails[index]) {
                tails[++index] = num;
            }
            int left = 1, right = index + 1;
            while (left < right) {
                int middle = left + (right - left) / 2;
                if (num > tails[middle]) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
            tails[left] = Math.min(num, tails[left]);

        }
        return index;
    }


}
