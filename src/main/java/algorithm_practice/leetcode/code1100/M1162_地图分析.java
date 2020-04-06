package algorithm_practice.leetcode.code1100;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 * <p>
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 * <p>
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/as-far-from-land-as-possible
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1162_地图分析 {

    class coordinate {
        int x;
        int y;
        int depth;

        public coordinate(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }


    int[][] grid;

    int[][] dest = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    int bfs(int row, int column) {
        boolean[][] visited = new boolean[grid.length][grid.length];
        if (visited[row][column]) {
            return -1;
        }
        int size = 0;
        Queue<coordinate> queue = new LinkedList<>();
        queue.add(new coordinate(row, column, 0));
        while (!queue.isEmpty()) {
            coordinate k = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = k.x + dest[i][0];
                int y = k.y + dest[i][1];
                int depth = k.depth + 1;
                if (x >= 0 && x < grid.length && y >= 0 && y < grid.length && !visited[x][y]) {
                    visited[x][y] = true;
                    if (this.grid[x][y] == 0) {
                        queue.add(new coordinate(x, y, depth));
                    } else {
                        return depth;
                    }
                }
            }
        }
        return -1;
    }

    public int maxDistanceON4(int[][] grid) {
        if (grid.length == 0) return 0;
        this.grid = grid;

        int ans = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    ans = Math.max(ans, bfs(i, j));
                }
            }
        }

        return ans;

    }

    //从每个岛节点出发
    public int maxDistance(int[][] grid) {
        Queue<coordinate> queue = new ArrayDeque<>();
        int res = -1;
        boolean[][] visited = new boolean[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    queue.add(new coordinate(i, j, 0));
                }
            }
        }
        int[][] dest = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        if (queue.size() == grid.length * grid.length)
            return -1;
        while (!queue.isEmpty()) {
            coordinate k = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = k.x + dest[i][0];
                int y = k.y + dest[i][1];
                int depth = k.depth + 1;
                if (x >= 0 && x < grid.length && y >= 0 && y < grid.length && !visited[x][y]) {
                    visited[x][y] = true;
                    res = Math.max(res, depth);
                    queue.add(new coordinate(x, y, depth));
                }
            }
        }
        return res;
    }

}


