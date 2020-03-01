package algorithm_practice.leetcode.code0000;

import common.datastructure.ListNode;
import org.junit.Test;


import java.util.*;


public class M0090_子集II {


    @Test
    public void testM0090() {
        int[] nums = {1, 2, 3};
        List<Integer> path = new ArrayList<>();

        subsetsWithDup(nums);
    }


    private int[] nums;

    public void traceBack(List<Integer> path, int target, int start, List<List<Integer>> ans) {
        if (path.size() == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        int limit = this.nums.length - target + 1 + path.size();
        for (int i = start; i < limit; i++) {
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            path.add(this.nums[i]);
            traceBack(path, target, i + 1, ans);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int target = 0; target <= nums.length; target++) {
            traceBack(new ArrayList<>(), target, 0, res);
        }
        return res;
    }
}
