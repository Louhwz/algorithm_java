package algorithm_practice.leetcode.code0500;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 * <p>
 * 示例 1:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 * <p>
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/01-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0542_01矩阵 {

    private int[][] dest = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int[][] updateMatrix(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new Pair<>(i, j));
                } else {
                    matrix[i][j] = -1;
                }
            }
        }
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = temp.getKey() + dest[i][0];
                int newY = temp.getValue() + dest[i][1];
                if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length && matrix[newX][newY] == -1) {
                    matrix[newX][newY] = matrix[temp.getKey()][temp.getValue()] + 1;
                    queue.offer(new Pair<>(newX, newY));
                }
            }
        }
        return matrix;
    }

    private int[][] tt(int[][] temp) {
        return temp;
    }

    @Test
    public void test() {
            int[][] kk = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int[][] cc = tt(kk);
        cc[0][0] = 100;
        System.out.println(kk[0][0]);
    }
}
