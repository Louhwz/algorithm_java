package algorithm_practice.leetcode.code0100;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 你可以假设数组中不存在重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 连续区间+区间
 */
public class M0153_寻找旋转排序数组中的最小值 {
    public int findMinOne(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length;
        int base = nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid >= 1 && nums[mid] < nums[mid - 1]) {
                left = mid;
                break;
            }
            if (nums[mid] > base) {
                left = mid + 1;
            } else if (nums[mid] <= base) {
                right = mid;
            }
        }
        return nums[left];
    }

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (left == right) {
                return left;
            }
            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
