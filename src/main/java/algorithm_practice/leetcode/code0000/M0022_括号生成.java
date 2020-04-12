package algorithm_practice.leetcode.code0000;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0022_括号生成 {
    private List<String> res = new ArrayList<>();
    private int n;

    private void dfs(int left, int right, String path) {
        if (left == n && right == n) {
            res.add(path);
        }

        if (left < n) {
            dfs(left + 1, right, path + "(");
        }
        if (left > right) {
            dfs(left, right + 1, path + ")");
        }
    }

    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(0, 0, "");
        return this.res;
    }

    private void backtrace(Stack<Integer> stack, int n, int left, int right, String path) {
        if (left == n && right == n) {
            res.add(path);
            return;
        }
        if (left < n) {
            stack.push(1);
            path += "(";
            backtrace(stack, n, left + 1, right, path);
        }
        if (!stack.isEmpty()) {
            stack.pop();
            path += ")";
            Stack<Integer> s = (Stack<Integer>) stack.clone();
            String k = new String(path);
            backtrace(s, n, left, right + 1, k);
        }

    }

    /**
     * 记录生成括号路径
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesisStack(int n) {
        res = new ArrayList<>();
        //Stack<Integer> stack = new Stack<>();
        String path = "";
        backtrace(new Stack<Integer>(), n, 0, 0, path);

        return res;
    }

    private void seeHashCode(String s) {
        System.out.println("被调用函数内:" + s.hashCode());
        String temp = "123";
        String temp2 = "";
        System.out.println("另一个string:" + temp.hashCode());
        System.out.println("temp==s?:" + temp.equals(s));
        System.out.println("temp==temp2?:" + temp.equals(temp2));
    }

    @Test
    public void test0022() {
        String s = "";
        System.out.println("调用函数内:" + s.hashCode());
        seeHashCode(s);
        //System.out.println(generateParenthesis(3));
    }
}
