package algorithm_practice.leetcode.code1000;


import org.junit.Test;

/**
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * <p>
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 示例 2：
 * <p>
 * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：[3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 3 <= A.length <= 50000
 * -10^4 <= A[i] <= 10^4
 */
public class E1013_将数组分成和相等的三个部分 {
    /**
     * 双指针
     * [0,left],(left,right),[right,A.length-1]
     *
     * @param A
     * @return
     */
    public boolean canThreePartsEqualSumN2(int[] A) {
        int left = 0, right = A.length - 1;
        while (left + 1 < right) {
            long partitionLeft = 0, partitionMiddle = 0, partitionRight = 0;
            for (int i = 0; i <= left; i++) {
                partitionLeft += A[i];
            }
            for (int i = left + 1; i < right; i++) {
                partitionMiddle += A[i];
            }
            for (int i = right; i < A.length; i++) {
                partitionRight += A[i];
            }
            if (partitionLeft != partitionMiddle || partitionLeft != partitionRight || partitionMiddle != partitionRight) {
                left++;
            } else {
                return true;
            }
            while (left + 1 < right) {
                partitionLeft += A[left];
                partitionMiddle -= A[left];
                if (partitionLeft == partitionMiddle && partitionLeft == partitionRight) {
                    return true;
                }
                left++;
            }
            left = 0;
            right--;
        }
        return false;
    }


    @Test
    public void test1013() {
        canThreePartsEqualSum(new int[]{
                12, -4, 16, -5, 9, -3, 3, 8, 0
        });
    }

    public boolean canThreePartsEqualSum(int[] A) {
        long sum = 0;
        for (int k :
                A) {
            sum += k;
        }
        long target = sum / 3;
        if (target * 3 != sum) {
            return false;
        }
        int left = 0, right = A.length - 1;
        long partitionLeft = A[left], partitionRight = A[right];
        while (left + 1 < right) {
            if (partitionLeft == target && partitionRight == target) {
                return true;
            }
            if (partitionLeft != target) {
                partitionLeft += A[++left];
            }
            if (partitionRight != target) {
                partitionRight += A[--right];
            }
        }
        return false;
    }
}
