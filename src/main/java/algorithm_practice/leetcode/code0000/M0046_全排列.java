package algorithm_practice.leetcode.code0000;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0046_全排列 {

    private List<List<Integer>> res = new ArrayList<>();
    private int n;
    private int[] nums;

    private void backtracking(List<Integer> path, boolean[] visited) {
        if (path.size() == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.add(i);
                backtracking(path, visited);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        backtracking(new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    @Test
    public void test() {
        permute(new int[]{1, 2, 3});

    }
}
