package algorithm_practice.leetcode.code0000;

import common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class M0094_二叉树的中序遍历 {
    List<Integer> res = new ArrayList<Integer>();

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }

    public List<Integer> inorderTraversalRecursion(TreeNode root) {

        inorder(root);
        return res;

    }

    public class ColorNode {
        public TreeNode treeNode;
        public String color;

        ColorNode(TreeNode node) {
            this.treeNode = node;
            color = "white";
        }
    }

    /**
     * 颜色标记法，解决二叉树递归的好方法
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root));
        while (!stack.empty()) {
            ColorNode k = stack.pop();
            if (k.color.equals("white")) {
                if (k.treeNode.right != null) {
                    stack.push(new ColorNode(k.treeNode.right));
                }
                k.color = "grey";
                stack.push(k);
                if (k.treeNode.left != null) {
                    stack.push(new ColorNode(k.treeNode.left));
                }
            } else {
                res.add(k.treeNode.val);
            }
        }
        return res;
    }
}
