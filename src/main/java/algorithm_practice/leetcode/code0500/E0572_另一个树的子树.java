package algorithm_practice.leetcode.code0500;

import common.datastructure.TreeNode;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * <p>
 * 示例 1:
 * 给定的树 s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 2:
 * 给定的树 s：
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * 返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E0572_另一个树的子树 {
    private boolean dfs(TreeNode s, TreeNode t) {
        if (s == null && t != null || s != null && t == null) {
            return false;
        }
        if (s == null && t == null)
            return true;
        if (s.val != t.val)
            return false;
        return dfs(s.left, t.left) && dfs(s.right, t.right);
    }

    private boolean preOrder(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (s.val == t.val) {
            if (dfs(s.left, t.left) && dfs(s.right, t.right))
                return true;
        }
        return preOrder(s.left, t) || preOrder(s.right, t);
    }

    public boolean isSubtreePreOrder(TreeNode s, TreeNode t) {
        return preOrder(s, t);
    }

    private void pre(TreeNode s, StringBuilder st) {
        if (s == null)
            return;
        st.append(s.val);
        pre(s.left, st);
        pre(s.right, st);
    }

    private void in(TreeNode s, StringBuilder st) {
        if (s == null)
            return;

        in(s.left, st);
        st.append(s.val);
        in(s.right, st);
    }

    private void post(TreeNode s, StringBuilder st) {
        if (s == null)
            return;

        post(s.left, st);

        post(s.right, st);
        st.append(s.val);
    }

    public boolean isSubtreeStupid(TreeNode s, TreeNode t) {
        StringBuilder ss = new StringBuilder();
        StringBuilder tt = new StringBuilder();
        pre(s, ss);
        pre(t, tt);
        StringBuilder si = new StringBuilder();
        StringBuilder ti = new StringBuilder();
        in(s, si);
        in(t, ti);

        StringBuilder sp = new StringBuilder();
        StringBuilder tp = new StringBuilder();
        in(s, sp);
        in(t, tp);
        return ss.indexOf(tt.toString()) != -1 && si.indexOf(ti.toString()) != -1 && sp.indexOf(tp.toString()) != -1;
    }

    private void prepre(TreeNode s, StringBuilder st) {
        if (s == null)
            return;
        st.append(s.val);
        prepre(s.left, st);
        st.append('l');
        prepre(s.right, st);
        st.append('r');
    }


    public static double sqrt(double x, double precision) {
        if (x < 0) {
            return Double.NaN;
        }
        double low = 0;
        double up = x;
        if (x < 1 && x > 0) {
/** 小于1的时候*/
            low = x;
            up = 1;
        }
        double mid = low + (up - low) / 2;
        while (up - low > precision) {
            if (mid * mid > x) {//TODO mid可能会溢出
                up = mid;
            } else if (mid * mid < x) {
                low = mid;
            } else {
                return mid;
            }
            mid = low + (up - low) / 2;
        }
        return mid;
    }

    @Test
    public void test() {
        TreeNode s = new TreeNode(2);
        s.left = new TreeNode(1);
        s.right = new TreeNode(3);
        StringBuilder st = new StringBuilder();
        prepre(s, st);
        System.out.println(st.toString());

        System.out.println(sqrt(16, 0.000001));
    }
    //1024Byte = 1 KiloByte = 128 num
    //1024 KiloByte = 1 MB = 128 *1024 num
    //80MN =
}
