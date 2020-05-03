package algorithm_practice.leetcode.code0600;

import common.datastructure.TreeNode;

/**
 * 687. 最长同值路径
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * <p>
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * 输出:
 * <p>
 * 2
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 * 输出:
 * <p>
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 */
public class E0687_最长同值路径 {
    int ans = 0;

    public int recursion(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;
        int left = 0, right = 0;
        if (root.left != null) {
            if (root.val == root.left.val) {
                left = 1 + recursion(root.left);
            } else
                left = recursion(root.left);
        }
        if (root.right != null) {
            if (root.val == root.right.val) {
                right = 1 + recursion(root.right);
            } else
                right = recursion(root.right);
        }
        if (root.left != null && root.right != null && root.left.val == root.right.val && root.val == root.left.val) {
            ans = Math.max(ans, left + right);
        }
        ans = Math.max(ans, Math.max(left, right));
        return Math.max(left, right);
    }

    public int rec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sonLeft = rec(root.left);   //以root.left.val的值的向下延伸的最大深度
        int sonRight = rec(root.right);
        int left = 0, right = 0;
        if (root.left != null && root.left.val == root.val) {
            left = sonLeft + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right = sonRight + 1;
        }
        ans = Math.max(ans, left + right);
        return Math.max(left, right);
    }

    public int longestUnivaluePath(TreeNode root) {
//        int left = recursion(root.left);
//        int right = recursion(root.right);
//        if (root.left != null && root.val == root.left.val) {
//            left++;
//        }
//        if (root.right != null && root.val == root.right.val) {
//            right++;
//        }
//        return Math.max(left, right);
        rec(root);
        return ans;
    }
}
