package algorithm_practice.leetcode.code0100;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class E0169_多数元素 {

    @Test
    public void test0169() {
        int[] k = new int[]{
                1, 2, 3
        };

    }

    public int majorityElementSort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 摩尔投票法
     *
     * @param nums
     * @return
     */
    public int majorityElementON(int[] nums) {
        int candidate = 0;
        int count = 0;
        int[] k = new int[]{1, 2, 3, 4};
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            if (mp.containsKey(num)) {
                mp.put(num, mp.get(num) + 1);
            } else {
                mp.put(num, 1);
            }
        }
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : mp.entrySet()) {
            if (majorityEntry == null || integerIntegerEntry.getValue() > majorityEntry.getValue()) {
                majorityEntry = integerIntegerEntry;
            }
        }
        return majorityEntry.getKey();

    }
}
