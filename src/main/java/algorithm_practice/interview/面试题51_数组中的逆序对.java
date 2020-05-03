package algorithm_practice.interview;


/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 面试题51_数组中的逆序对 {
    public int reversePairs(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }

    private int merge(int[] nums, int start, int end) {
        if (start >= end)
            return 0;
        int mid = start + (end - start) / 2;
        int count = merge(nums, start, mid) + merge(nums, mid + 1, end);
        int[] temp = new int[end - start + 1];

        int ins_start = start, ins_right = mid + 1, k = 0;
        while (ins_start <= mid && ins_right <= end) {
            count += (nums[ins_start] <= nums[ins_right]) ? ins_right - mid - 1 : 0;
            temp[k++] = (nums[ins_start] <= nums[ins_right]) ? nums[ins_start++] : nums[ins_right++];
        }
        while (ins_start <= mid) {
            count += (ins_right - mid - 1);
            temp[k++] = nums[ins_start++];
        }
        while (ins_right <= end) {
            temp[k++] = nums[ins_right++];
        }
        System.arraycopy(temp, 0, nums, start, end - start + 1);
        return count;
    }
}
