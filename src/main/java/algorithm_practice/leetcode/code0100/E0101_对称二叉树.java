package algorithm_practice.leetcode.code0100;

import common.datastructure.TreeNode;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 说明:
 * <p>
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E0101_对称二叉树 {

    private boolean equal(TreeNode a, TreeNode b) {
        return a == null ? b == null : (a.val == b.val);
    }

    public boolean isSymmetricNonRecursion(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root == null)
            return false;
        else
            q.offer(root);
        while (!q.isEmpty()) {
            TreeNode[] tn = new TreeNode[q.size()];
            q.toArray(tn);
            for (int i = 0; i < tn.length / 2; i++) {
                if (!equal(tn[i], tn[tn.length - i - 1])) {
                    return false;
                }
            }
            Queue<TreeNode> temp = new ArrayDeque<>();
            while (!q.isEmpty()) {
                TreeNode front = q.poll();
                if (front.val == Integer.MIN_VALUE) {
                    continue;
                } else {
                    if (front.left == null)
                        temp.offer(new TreeNode(Integer.MIN_VALUE));
                    else
                        temp.offer(front.left);
                    if (front.right == null)
                        temp.offer(new TreeNode(Integer.MIN_VALUE));
                    else
                        temp.offer(front.right);
                }
            }
            q = temp;
        }
        return true;
    }

    private boolean isMirror(TreeNode rl, TreeNode rr) {
        if (rl == null && rr == null) return true;
        if (rl == null || rr == null) return false;
        return (rl.val == rr.val) && isMirror(rl.left, rr.right) && isMirror(rl.right, rr.left);
    }

    /**
     * 递归版本
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    @Test
    public void test101() {
        Queue<TreeNode> test= new LinkedList<>();
        test.add(null);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = null;
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = null;
        System.out.println(isSymmetric(root));
    }
}
