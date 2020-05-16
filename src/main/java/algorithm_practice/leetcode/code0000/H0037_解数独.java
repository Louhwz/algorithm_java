package algorithm_practice.leetcode.code0000;

import com.sun.deploy.net.proxy.WFirefoxProxyConfig;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * <p>
 * <p>
 * <p>
 * 一个数独。
 * <p>
 * <p>
 * <p>
 * 答案被标成红色。
 * <p>
 * Note:
 * <p>
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * 通过次数27,144提交次数44,284
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class H0037_解数独 {
    int[][] setRow = new int[9][9 + 1];
    int[][] setColumn = new int[9][9 + 1];
    int[][] setSudoku = new int[9][9 + 1];
    boolean[][] visited = new boolean[9][9];
    char[][] board;

    private boolean checkValid() {
        for (int i = 0; i < 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (setRow[i][j] != 1)
                    return false;
            }
        }
        return true;
    }

    private boolean getNextValid(int i, int j, int k) {
        return (setRow[i][k] + setColumn[j][k] + setSudoku[i / 3 * 3 + j / 3][k]) == 0;
    }

    private void setIJK(int i, int j, int k) {
        setRow[i][k] = 1;
        setColumn[j][k] = 1;
        setSudoku[i / 3 * 3 + j / 3][k] = 1;
        board[i][j] = (char) ((char)k + '0');

    }

    private void removeIJK(int i, int j, int k) {
        setRow[i][k] = 0;
        setColumn[j][k] = 0;
        setSudoku[i / 3 * 3 + j / 3][k] = 0;
    }

    private boolean backtrack() {
        if (checkValid()) {
            return true;
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!visited[i][j]) {
                    for (int k = 1; k <= 9; k++) {
                        if (getNextValid(i, j, k)) {
                            visited[i][j] = true;
                            setIJK(i, j, k);
                            if (backtrack()) {
                                return true;
                            }
                            removeIJK(i, j, k);
                            visited[i][j] = false;
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        this.board = board;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int k = board[i][j] - '0';
                    visited[i][j] = true;
                    setRow[i][k] = 1;
                    setColumn[j][k] = 1;
                    setSudoku[i / 3 * 3 + j / 3][k] = 1;
                }
            }
        }
        backtrack();
        board = this.board;
    }

    @Test
    public void test() {

        char[][] k = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(k);
        System.out.println(k);
    }
}
