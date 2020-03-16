package algorithm_practice.swordtooffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 面试题57II_和为s的连续正数序列 {

    @Test
    public void test57II() {
        System.out.println(findContinuousSequence(9));
    }

    int sumSequence(int start, int end) {
        return (start + end) * (end - start + 1) / 2;
    }

    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 2, sum = 3, limit = target / 2 + 1;
        List<int[]> res = new ArrayList<>();
        while (left < limit) {
            if (sum < target) {
                right++;
                sum += right;
            } else if (sum > target) {
                sum -= left;
                left++;

            } else {
                int[] path = new int[right - left + 1];
                for (int index = 0, cur = left; cur <= right; index++, cur++) {
                    path[index] = cur;
                }
                res.add(path);
                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);

    }


    public int[][] findContinuousSequence_nlogn(int target) {
        List<int[]> res = new ArrayList<>();

        for (int i = 1; i <= target / 2 + 1; i++) {
            int left = i, right = target;
            while (left < right) {
                int middle = left + (right - left) / 2;
                int s = sumSequence(i, middle);
                if (s == target) {
                    left = middle;
                    break;
                } else if (s <= 0 || s > target) {
                    right = middle;
                } else if (s < target) {
                    left = middle + 1;
                }
            }
            if (sumSequence(i, left) == target) {
                int[] path = new int[left - i + 1];
                if (path.length == 1) {
                    continue;
                }
                for (int j = i, index = 0; j <= left; j++, index++) {
                    path[index] = j;
                }
                res.add(path);

            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
