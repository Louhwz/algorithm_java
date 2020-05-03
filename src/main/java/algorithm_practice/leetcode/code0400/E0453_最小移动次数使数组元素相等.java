package algorithm_practice.leetcode.code0400;

import java.util.Arrays;

//1 60 80 100
//99 100 159 179 100
//79 179 238 179 179
//59 238 238 238 238

//5 5 6 8 8
//3 8 8 9 8 11
//3 11 11 12 11 11
//1

//1 9 9
//8 9 9 17
//8 17 17 17

//[83,86,77,15,93,35,86,92,49,21]
//
public class E0453_最小移动次数使数组元素相等 {

    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int opt = 0;

        for (int i = 1; i < nums.length; i++) {
            opt += (nums[i] - nums[0]);
        }
        return opt;
    }
}
