package algorithm_practice.leetcode.code0900;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Queue;

public class E0994_腐烂的橘子 {

    private int[][] dest = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int ans = 0;

    void bfs(int[][] grid, boolean[][] visited, int ii, int jj) {
        visited[ii][jj] = true;
        if (grid[ii][jj] == 1) {
            grid[ii][jj] = 2;
        } else if (grid[ii][jj] == 0) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nowI = ii + dest[i][0];
            int nowJ = jj + dest[i][1];
            if (nowI >= 0 && nowI < grid.length && nowJ >= 0 && nowJ < grid[0].length) {
                if (!visited[nowI][nowJ]) {
                    bfs(grid, visited, nowI, nowJ);
/*                    if (grid[nowI][nowJ] != 0) {

                    }*/
                }
            }
        }
    }

    public int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];


        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair<>(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {

            Queue<Pair<Integer, Integer>> temp = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                Pair<Integer, Integer> k = queue.remove();
                int ti = k.getKey();
                int tj = k.getValue();
                for (int i = 0; i < 4; i++) {
                    Integer tempi = ti + dest[i][0];
                    Integer tempj = tj + dest[i][1];
                    if (tempi >= 0 && tempi < grid.length && tempj >= 0 && tempj < grid[0].length && !visited[tempi][tempj]) {
                        visited[tempi][tempj] = true;
                        if (grid[tempi][tempj] == 0) {
                            continue;
                        }
                        if (grid[tempi][tempj] == 1) {
                            grid[tempi][tempj] = 2;
                        }
                        temp.add(new Pair<Integer, Integer>(tempi, tempj));
                    }
                }
            }

            queue = temp;
            if(!queue.isEmpty()){
                ans++;
            }
        }


        //bfs(grid, visited, ii, jj);
        for (int[] k :
                grid) {
            for (int t :
                    k) {
                if (t == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }
}
