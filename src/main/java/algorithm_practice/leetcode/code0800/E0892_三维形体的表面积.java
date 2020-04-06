package algorithm_practice.leetcode.code0800;

import org.junit.Test;

/**
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * <p>
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * <p>
 * 请你返回最终形体的表面积。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[2]]
 * 输出：10
 * 示例 2：
 * <p>
 * 输入：[[1,2],[3,4]]
 * 输出：34
 * 示例 3：
 * <p>
 * 输入：[[1,0],[0,2]]
 * 输出：16
 * 示例 4：
 * <p>
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 示例 5：
 * <p>
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E0892_三维形体的表面积 {

    public int surfaceArea(int[][] grid) {
    /*    int res = 0;
        int maxHeight = 0;
        //int[] front = new int[grid.length];
        int[] back = new int[grid.length];
        int[] left = new int[grid.length];
        int[] leftIndex = new int[grid.length];
        int[] rightIndex = new int[grid.length];
        int[] backIndex = new int[grid.length];
        int[] frontIndex = new int[grid.length];
        //int[] right = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            leftIndex[i]=-1;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    res += 2;
                    back[j] = Math.max(back[j], grid[i][j]);
                    left[i] = Math.max(left[i], grid[i][j]);
                    //right
                    if(leftIndex[i]==-1){
                        leftIndex[i]=j;
                    }
                    rightIndex[i] = Math.max(rightIndex[i],j);
                    if(backIndex[j] == -1){
                        backIndex[j] = i;
                    }
                    frontIndex[j] = Math.max(frontIndex[j],i);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            res += back[i] * 2;
            res += left[i] * 2;
            for (int j = 0; j < grid.length; j++) {
                if(grid[i][j]==0 && )
            }
        }
        return res;*/
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] != 0) {
                    res += area(grid[i][j]);
                    if (j < grid.length - 1) {
                        if (grid[i][j + 1] != 0) {
                            res -= 2 * Math.min(grid[i][j], grid[i][j + 1]);
                        }
                    }
                    if (i < grid.length - 1) {
                        if (grid[i + 1][j] != 0) {
                            res -= 2 * Math.min(grid[i + 1][j], grid[i][j]);
                        }
                    }
                }
            }
        }
        return res;
    }

    private int area(int floors) {
        //1 6 2 10 3 14
        return floors * 4 + 2;
    }
}
