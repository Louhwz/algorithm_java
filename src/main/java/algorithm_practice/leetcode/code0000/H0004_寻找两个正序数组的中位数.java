package algorithm_practice.leetcode.code0000;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 4 5 12 15
 * 1 3 7
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class H0004_寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int knum = 0;
        if (total % 2 == 0) {
            knum = total / 2 - 1;
        } else {
            knum = total / 2;
        }
        int s1 = 0, e1 = nums1.length - 1, mid1 = (s1 + e1) / 2;
        int s2 = 0, e2 = nums2.length - 1, mid2 = (s2 + e2) / 2;
        while (knum != 0) {
            if (mid1 > e1) {
                mid2 = s2 + knum;
                break;
            }
            if (mid2 > e2) {
                mid1 = s1 + knum;
                break;
            }
            if (nums1[mid1] <= nums2[mid2]) {
                knum -= (mid1 + 1 - s1);
                if (knum < 0) {
                    s1 = mid1 + knum;
                    knum = 0;
                } else {
                    s1 = mid1 + 1;
                }
                if (s1 > e1)
                    mid1 = s1;
                else
                    mid1 = (s1 + e1) / 2;
            } else {
                knum -= (mid2 + 1 - s2);
                if (knum < 0) {
                    s2 = mid2 + knum;
                    knum = 0;
                } else {
                    s2 = mid2 + 1;

                }
                if (s2 > e2)
                    mid2 = s2;
                else
                    mid2 = (s2 + e2) / 2;
            }
        }

        if (total % 2 == 0) {
            if (mid1 > e1) {
                mid2 = s2 + knum;
            }
            if (mid2 > e2) {
                mid1 = s1 + knum;
            }
            int[] k = new int[]{mid1 > e1 ? Integer.MAX_VALUE : nums1[mid1++], mid1 > e1 ? Integer.MAX_VALUE : nums1[mid1], mid2 > e2 ? Integer.MAX_VALUE : nums2[mid2++], mid2 > e2 ? Integer.MAX_VALUE : nums2[mid2++]};
            Arrays.sort(k);

            return ((double) k[0] + (double) k[1]) / 2;
        } else {
            if (mid1 > e1)
                return nums2[mid2];
            if (mid2 > e2)
                return nums1[mid1];
            return Math.min(nums1[mid1], nums2[mid2]);
        }
    }

    @Test
    public void test() {
        Assert.assertEquals(2.5, findMedianSortedArrays(new int[]{1}, new int[]{2, 3, 4}), 1e-6);
        Assert.assertEquals(2.0, findMedianSortedArrays(new int[]{2}, new int[]{1, 3, 4}), 1e-6);

        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4, 5, 6, 7, 8}));
        System.out.println(findMedianSortedArrays(new int[]{1, 9, 11}, new int[]{7, 12}));
        System.out.println(findMedianSortedArrays(new int[]{1, 1}, new int[]{1, 2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 1, 3, 3}, new int[]{1, 1, 3, 3}));


    }
}
