package algorithm_practice.leetcode.code0100;

import common.datastructure.TreeNode;
import org.junit.Test;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0105_从前序与中序遍历序列构造二叉树 {

    private int[] preorder, inorder;

    private TreeNode BUILDTREE(int preS, int inS, int len) {
        if (len == 0)
            return null;
        if (len == 1)
            return new TreeNode(preorder[preS]);
        TreeNode root = new TreeNode(preorder[preS]);
        int rootPosition = 0;
        for (int i = inS; i < inS + len; i++) {
            if (inorder[i] == preorder[preS]) {
                rootPosition = i;
                break;
            }
        }
        int llen = rootPosition - inS;
        int rlen = inS + len - rootPosition - 1;
        root.left = BUILDTREE(preS + 1, inS, llen);
        root.right = BUILDTREE(preS + llen + 1, rootPosition + 1, rlen);
        return root;

    }

    //前序选根，在中序里确定左子树和右子树
    //左右子树选完后，在前序中也能确定左右子树，此时再确定左右子树的根
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        this.preorder = preorder;
        this.inorder = inorder;
        TreeNode root = new TreeNode(preorder[0]);
        int rootPosition = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                rootPosition = i;
                break;
            }
        }
        int leftLength = rootPosition;
        int rightLength = inorder.length - rootPosition - 1;
        root.left = BUILDTREE(1, 0, leftLength);
        root.right = BUILDTREE(1 + leftLength, rootPosition + 1, rightLength);
        return root;
    }

}
