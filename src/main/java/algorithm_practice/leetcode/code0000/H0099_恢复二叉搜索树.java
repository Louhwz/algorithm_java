package algorithm_practice.leetcode.code0000;

import com.sun.deploy.panel.ITreeNode;
import common.datastructure.TreeNode;
import javafx.util.Pair;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树中的两个节点被错误地交换。
 * <p>
 * 请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,null,null,2]
 * <p>
 *    1
 *   /
 *  3
 *   \
 *    2
 * <p>
 * 输出: [3,1,null,null,2]
 * <p>
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 * <p>
 * 输入: [3,1,4,null,null,2]
 * <p>
 * 3
 * / \
 * 1   4
 *    /
 *   2
 * <p>
 * 输出: [2,1,4,null,null,3]
 * <p>
 * 2
 * / \
 * 1   4
 *    /
 *  3
 * <p>
 * 进阶:
 * <p>
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 * <p>
 * 4 2 3 1
 * 1 2 3 4 5 6
 * 1 5 3 4 2 6
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class H0099_恢复二叉搜索树 {


    @Test
    public void test0099() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        //*********************************
        //1 3 2 4
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.right.left = new TreeNode(2);
        recoverTree(root1);
    }

    private void inOrder(TreeNode root, List<Integer> integerList) {
        if (root == null) {
            return;
        }
        inOrder(root.left, integerList);
        integerList.add(root.val);
        inOrder(root.right, integerList);
    }

    /**
     * 在一个有序数组中找出调换了两个数的位置的经典算法，起码，“大萨特和小萨特”
     * 1 2 3 4 5
     * 1 4 3 2 5
     *
     * @param integerList
     * @return
     */
    private Pair<Integer, Integer> findInverseNumber(List<Integer> integerList) {
        int x = -1, y = -1;

        for (int i = 0; i < integerList.size() - 1; i++) {
            if (integerList.get(i + 1) < integerList.get(i)) {
                y = integerList.get(i + 1);
                if (x == -1) {
                    x = integerList.get(i);
                } else {
                    break;
                }
            }
        }
        return new Pair<>(x, y);
    }

    private void changeValue(TreeNode root, Pair<Integer, Integer> pair) {
        if (root == null) {
            return;
        }
        changeValue(root.left, pair);

        if (root.val == pair.getKey()) {
            root.val = pair.getValue();
        } else if (root.val == pair.getValue()) {
            root.val = pair.getKey();
            return;
        }
        changeValue(root.right, pair);


    }

    public void recoverTree(TreeNode root) {
        List<Integer> integerList = new ArrayList<>();
        inOrder(root, integerList);
        Pair<Integer, Integer> pair = findInverseNumber(integerList);

        changeValue(root, pair);
    }
}
