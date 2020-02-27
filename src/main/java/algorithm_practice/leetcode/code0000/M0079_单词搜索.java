package algorithm_practice.leetcode.code0000;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author Louhwz
 */
public class M0079_单词搜索 extends TestCase {

    @Test
    public void testCase() {
/*        char[][] s = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String k = "ABCESEEEFS";*/
        char[][] s = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String k = "ABCCED";
        M0079_单词搜索 solution = new M0079_单词搜索();
        System.out.println(solution.exist(s, k));
    }


    private char[][] board;
    private boolean[][] visited;
    private String word;
    private int row;
    private int column;
    private int[][] dest = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
//    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.board = board;
        row = board.length;
        if (row == 0) {
            return false;
        }
        column = board[0].length;
        visited = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index) {
        if (index == word.length() - 1) {
            return board[i][j] == word.charAt(index);
        }
        if (board[i][j] == word.charAt(index)) {
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newI = i + dest[k][0];
                int newJ = j + dest[k][1];
                if (inArea(newI, newJ) && !visited[newI][newJ]) {
                    if (dfs(newI, newJ, index + 1)) {
                        return true;
                    }
                }
            }
            visited[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int newI, int newJ) {
        return newI >= 0 && newI < row && newJ >= 0 && newJ < column;
    }

 /*   private boolean dfs(char[][] board, int i, int j, boolean[][] visited, int index) {
        if (index == this.word.length()) {
            return true;
        }

        if (i >= this.row || i < 0 || j >= this.column || j < 0) {
            return false;
        }
        if (visited[i][j] || board[i][j] != this.word.charAt(index)) {
            return false;
        }
        for (int k = 0; k < 4; k++) {
            visited[i][j] = true;
            index++;
            if (dfs(board, i + this.dest[k][0], j + this.dest[k][1], visited, index)) {
                return true;
            }
            visited[i][j] = false;
            index--;
        }
        return false;
    }*/


}
