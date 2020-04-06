package algorithm_practice.leetcode.code0000;

import common.datastructure.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0095_不同的二叉搜索树 {
    public List<TreeNode> Recursion(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        if (start == end) {
            TreeNode k = new TreeNode(start);
            res.add(k);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = Recursion(start, i - 1);
            List<TreeNode> rightTrees = Recursion(i + 1, end);
            for (TreeNode rightTree : rightTrees) {
                for (TreeNode leftTree : leftTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 0)
            return res;
        return Recursion(1, n);
    }
}
