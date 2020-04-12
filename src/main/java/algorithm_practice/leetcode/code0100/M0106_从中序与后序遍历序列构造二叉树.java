package algorithm_practice.leetcode.code0100;

import common.datastructure.TreeNode;

public class M0106_从中序与后序遍历序列构造二叉树 {
    private int[] inorder, postorder;

    private TreeNode build(int is, int ps, int len) {
        if (len == 0)
            return null;
        if (len == 1)
            return new TreeNode(inorder[is]);
        TreeNode root = new TreeNode(postorder[ps + len - 1]);
        int rp = is;
        while (inorder[rp] != postorder[ps + len - 1])
            rp++;
        int ll = rp - is;
        int rl = len - 1 - ll;
        root.left = build(is, ps, ll);
        root.right = build(rp + 1, ps + ll, rl);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0)
            return null;

        this.inorder = inorder;
        this.postorder = postorder;
        int val = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(val);
        int rp = 0;
        while (inorder[rp] != val)
            rp++;
        int ll = rp;
        int rl = inorder.length - rp - 1;
        root.left = build(0, 0, ll);
        root.right = build(rp + 1, ll, rl);
        return root;
    }
}
