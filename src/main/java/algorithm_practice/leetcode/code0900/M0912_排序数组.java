package algorithm_practice.leetcode.code0900;

import org.junit.Test;

/**
 * 给定一个整数数组 nums，将该数组升序排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：[5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -50000 <= A[i] <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0912_排序数组 {

    public int[] sortArraySelectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int k = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    k = j;
                    min = nums[j];
                }
            }
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
        return nums;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length - i; j++) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                }
            }
        }
    }

    //5 6
    //6 5
    private void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            int k = nums[i];
            while (j > 0 && nums[j - 1] > k) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = k;
        }
    }

    public int[] sortArray(int[] nums) {
        //bubbleSort(nums);
        insertionSort(nums);
        return nums;
    }

    @Test
    public void test0912() {
        int[] nums = new int[]{5, 1, 1, 2, 0, 0};
        sortArray(nums);
        return;
    }

}
