package algorithm_practice.leetcode.code0100;

import common.datastructure.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 1 2 3 4 5 6 7 8
 * 4
 * 2      6
 * 5    7
 * 8
 */
public class E0108_将有序数组转换为二叉搜索树 {
    private int[] nums;

    private TreeNode TreeNodesortTOBST(int s, int e) {
        if (e < s)
            return null;
        if (e == s)
            return new TreeNode(nums[s]);
        int middle = (s + e) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = TreeNodesortTOBST(s, middle - 1);
        root.right = TreeNodesortTOBST(middle + 1, e);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        this.nums = nums;
        TreeNode root = new TreeNode(nums[nums.length / 2]);
        root.left = TreeNodesortTOBST(0, nums.length / 2 - 1);
        root.right = TreeNodesortTOBST(nums.length / 2 + 1, nums.length - 1);
        return root;
    }
}
