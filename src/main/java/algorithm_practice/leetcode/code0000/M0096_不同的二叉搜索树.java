package algorithm_practice.leetcode.code0000;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0096_不同的二叉搜索树 {
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] num = new int[n + 1];
        num[0] = 1;
        num[1] = 1;
        num[2] = 2;
        for (int i = 3; i <= n; i++) {
            int tp = 0;
            for (int j = 1; j <= i; j++) {
                int left = Math.max(1, j - 1);
                int right = Math.max(1, i - j);
                tp += num[left] * num[right];
            }
            num[i] = tp;
        }
        return num[n];
    }
}
