package algorithm_practice.leetcode.code0200;

import common.datastructure.TreeNode;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中
 */
public class M0236_二叉树的最近公共祖先 {
    TreeNode ans = null;
    Integer c = 0;

    private void checkValid(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return;
        if (c == 0)
            return;
        if (root.val == p.val || root.val == q.val)
            c--;
        checkValid(root.left, p, q);
        checkValid(root.right, p, q);

    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return;
        c = 2;
        checkValid(root, p, q);
        if (c != 0)
            return;
        ans = root;
        dfs(root.left, p, q);
        dfs(root.right, p, q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = root;
        dfs(root.left, p, q);
        dfs(root.right, p, q);
        return ans;
    }

    @Test
    public void test() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(1);
//        root.left.left = new TreeNode(6);
//        root.left.right = new TreeNode(2);
//        System.out.println(lowestCommonAncestor(root, new TreeNode(6), new TreeNode(2)).val);
//        Integer k = 500;
//        System.out.println(k.hashCode());
//        k = 100;
//        System.out.println(k);
//        System.out.println(k.hashCode());
//        String s = "123";
//        s = "789";
//        System.out.println(s);


//        Class<?> clazz = Class.forName(
//                "java.lang.Integer$IntegerCache");
//        Field field = clazz.getDeclaredField("cache");
//        field.setAccessible(true);
//        Integer[] cache = (Integer[]) field.get(clazz);
//        System.out.println(cache[129]);
        Integer k = 1;
        k = 2;

        Integer m = 3;
        System.out.println("before k:" + k + " m:" + m);
        exchange(k, m);
        System.out.println("after k:" + k + " m:" + m);

    }


    private void exchange(Integer s, Integer m) throws NoSuchFieldException {
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            int tp = s.intValue();
            field.set(s, m);
            field.set(m, tp);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
