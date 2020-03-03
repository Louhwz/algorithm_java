package algorithm_practice.leetcode.code0000;

import org.junit.Test;

import java.awt.*;

public class E0088_合并两个有序数组 {

    @Test
    public void testGrammar() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        mergeO1(nums1, 3, nums2, 3);
    }

    /**
     * 时复最优，空复O(m+n)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num = new int[m + n];
        int a = 0, b = 0, index;
        for (index = 0; a < m && b < n; index++) {
            if (nums1[a] <= nums2[b]) {
                num[index] = nums1[a++];

            } else {
                num[index] = nums2[b++];
            }
        }
        if (a < m) {
            System.arraycopy(nums1, a, num, index, m - a);
        }
        if (b < n) {
            System.arraycopy(nums2, b, num, index, n - b);
        }
        index = 0;
        System.arraycopy(num, 0, nums1, 0, m + n);
    }

    /**
     * 空复O(1)，双指针从尾部开始遍历，利用了nums1后部元素没有信息的特点，也就是说，哪个部分没有信息就
     * 在哪部分直接修改
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeO1(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1, p1 = m - 1, p2 = n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[index--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        if (p2 >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }


    public void mergeAgain(int[] A, int m, int[] B, int n) {
        int index = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            A[index--] = A[m] < B[n] ? B[n--] : A[m--];
        }
        System.arraycopy(B, 0, A, 0, n + 1);

    }

}
