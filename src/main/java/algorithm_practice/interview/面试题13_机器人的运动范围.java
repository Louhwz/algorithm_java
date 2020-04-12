package algorithm_practice.interview;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 1：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 面试题13_机器人的运动范围 {

    @Test
    public void test13() {
        movingCount(16, 8, 4);
    }

    private int s(int i, int j) {
        int accumulation = 0;
        while (i != 0) {
            accumulation += i % 10;
            i /= 10;
        }
        while (j != 0) {
            accumulation += j % 10;
            j /= 10;
        }
        return accumulation;
    }

    private boolean checkValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public int movingCount(int m, int n, int k) {
        int ans = 0;
        Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();
        q.add(new Pair<>(0, 0));
        ans++;
        int[][] dest = new int[][]{{0, 1}, {1, 0}};
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        while (!q.isEmpty()) {
            Pair<Integer, Integer> root = q.poll();
            for (int i = 0; i < 2; i++) {
                int x = root.getKey() + dest[i][0];
                int y = root.getValue() + dest[i][1];
                if (checkValid(x, y, m, n) && s(x, y) <= k && !visited[x][y]) {
                    q.add(new Pair<>(x, y));
                    ans++;
                    visited[x][y] = true;
                }
            }
        }
        /*
        for (int i = 0; i < m; i++) {
            int guard = ans;
            for (int j = 0; j < n; j++) {
                if (s(i, j) > k) {
                    break;
                }
                ans++;
            }
            if (guard == ans)
                break;
        }*/
        return ans;
    }
}
