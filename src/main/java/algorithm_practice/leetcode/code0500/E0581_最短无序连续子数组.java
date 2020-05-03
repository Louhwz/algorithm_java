package algorithm_practice.leetcode.code0500;

import java.util.Arrays;

public class E0581_最短无序连续子数组 {
    public int findUnsortedSubarray(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int fi = 0;
        while (fi < nums.length && snums[fi] == nums[fi]) {
            fi++;
        }
        if (fi == nums.length)
            return 0;
        int en = nums.length - 1;
        while (en >= 0 && snums[en] == nums[en]) {
            en--;
        }
        return en - fi + 1;
    }
}
