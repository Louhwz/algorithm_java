package algorithm_practice.leetcode.code0600;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class M0695_岛屿的最大面积 {

    private int[][] dist = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    int row;
    int column;

    private boolean sizeUp(int a, int b) {
        return a >= 0 && a < row && b >= 0 && b < column;
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        this.row = grid.length;
        this.column = grid[0].length;
        int res = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] || grid[i][j] == 0) {
                    continue;
                }
                int k = 0;
                Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();
                q.add(new Pair<>(i, j));
                k += 1;
                visited[i][j] = true;
                while (!q.isEmpty()) {

                    Pair<Integer, Integer> c = q.remove();
                    for (int l = 0; l < 4; l++) {
                        if (sizeUp(c.getKey() + dist[l][0], c.getValue() + dist[l][1])) {
                            int simplifyA = c.getKey() + dist[l][0];
                            int simplifyB = c.getValue() + dist[l][1];
                            if (!visited[simplifyA][simplifyB] && grid[simplifyA][simplifyB] != 0) {
                                q.add(new Pair<>(simplifyA, simplifyB));
                                visited[simplifyA][simplifyB] = true;
                                k += 1;
                            }
                        }
                    }

                }
                res = Math.max(res, k);
            }

        }
        return res;
    }


}
