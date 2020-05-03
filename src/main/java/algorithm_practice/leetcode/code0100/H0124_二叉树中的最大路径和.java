package algorithm_practice.leetcode.code0100;

import common.datastructure.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [-10,9,20,null,null,15,7]
 * <p>
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 输出: 42
 */
public class H0124_二叉树中的最大路径和 {
    int ans = Integer.MIN_VALUE;

    public int recursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sonLeft = recursion(root.left);
        int sonRight = recursion(root.right);
        int left, right;
        left = Math.max(sonLeft + root.val, root.val);
        right = Math.max(sonRight + root.val, root.val);
        ans = Math.max(Math.max(Math.max(Math.max(left, right), root.val), sonLeft + sonRight + root.val), ans);
        return Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        recursion(root);
        return ans;
    }
}
