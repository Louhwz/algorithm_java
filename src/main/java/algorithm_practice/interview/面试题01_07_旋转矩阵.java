package algorithm_practice.interview;


import org.junit.Test;

/**
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * <p>
 * 不占用额外内存空间能否做到？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * 如何在不使用额外空间的情况下交换矩阵呢
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 面试题01_07_旋转矩阵 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n - 1 - 2 * i; j++) {
 /*               int[] to_rotate = new int[]{
                        matrix[0][j], matrix[j][n - 1], matrix[n - 1][n - 1 - j], matrix[n - 1 - j][0]
                };*/
                //step_back(to_rotate);
                int[] to_rotate = new int[]{
                        matrix[n - 1 - j - i][i], matrix[i][j + i], matrix[j + i][n - 1 - i], matrix[n - 1 - i][n - 1 - j - i]
                };
                matrix[i][j + i] = to_rotate[0];
                matrix[j + i][n - 1 - i] = to_rotate[1];
                matrix[n - 1 - i][n - 1 - j - i] = to_rotate[2];
                matrix[n - 1 - j - i][i] = to_rotate[3];
            }
        }
    }

    @Test
    public void test0107() {
        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(matrix);
        System.out.println(matrix);
    }
}
