package algorithm_practice.leetcode.code0100;

import common.datastructure.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0103_二叉树的锯齿形层次遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        int i = 0;
        if (root == null)
            return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> path = new ArrayList<>();
            Queue<TreeNode> temp = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                TreeNode tn_temp = queue.poll();
                path.add(tn_temp.val);
                if (tn_temp.left != null)
                    temp.add(tn_temp.left);
                if (tn_temp.right != null)
                    temp.add(tn_temp.right);

            }
            if (i % 2 == 1)
                Collections.reverse(path);
            res.add(path);
            i++;
            queue = temp;
        }
        return res;
    }

    @Test
    public void test0103() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        zigzagLevelOrder(root);
    }
}
