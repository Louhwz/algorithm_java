package algorithm_practice.leetcode.code0100;

import common.datastructure.TreeNode;
import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E0111_二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        if (root == null)
            return 0;
        queue.add(new Pair<>(root, 1));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode treeNode = pair.getKey();
            if (treeNode != null) {
                if (treeNode.left == null && treeNode.right == null) {
                    return pair.getValue();
                }
                int depth = pair.getValue();
                queue.add(new Pair<>(treeNode.left, depth + 1));
                queue.add(new Pair<>(treeNode.right, depth + 1));
            }
        }
        return -1;
    }
}
