package algorithm_practice.leetcode.code0000;

import common.datastructure.TreeNode;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:      1          1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * 输出: false
 * 示例 3:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * <p>
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E0100_相同的树 {

    private boolean res = true;

    public void preOrder(TreeNode p, TreeNode q) {
        if (p == null && q != null || p != null && q == null) {
            res = false;
            return;
        }
        if (p == null) {
            return;
        }
        if (p.val != q.val) {
            res = false;
            return;
        }
        preOrder(p.left, q.left);
        preOrder(p.right, q.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        preOrder(p, q);
        return res;
    }
}
