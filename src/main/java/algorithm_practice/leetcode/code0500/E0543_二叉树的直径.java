package algorithm_practice.leetcode.code0500;

import common.datastructure.TreeNode;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

public class E0543_二叉树的直径 {
    private int max = 0;

    @Test
    public void test0543() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));
    }
/*
    private int dfs(TreeNode root, int size) {
        if (root == null) {
            return size;
        }
        int k1 = dfs(root.left, size + 1);
        int k2 = dfs(root.right, size + 1);
        if (k1 + k2 - 2 * size > max) {
            max = k1 + k2;
        }
        return Math.max(k1, k2);
    }


    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(Math.abs(dfs(root.left, 0) + dfs(root.right, 0)), max);
    }*/


    /**
     * 自底向上，max记录每个节点的最大直径。
     * @param root
     * @return
     */
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;

    }

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }
}
