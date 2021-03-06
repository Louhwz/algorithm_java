package algorithm_practice.leetcode.code0100;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0137_只出现一次的数字II {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int k2 = 0;
        for (int num : nums) {
            set.add(num);
            k2 += num;
        }
        int k1 = 0;
        for (Integer integer : set) {
            k1 += integer;
        }
        return (3 * k1 - k2) / 2;
    }
}
