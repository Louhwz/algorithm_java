package algorithm_practice.leetcode.code0000;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class M0055_跳跃游戏 {
    private int[] nums;
    private boolean[] jump;
    private boolean[] visited;

    private boolean dfs(int start) {
        if (visited[start]) {
            return jump[start];
        }

        visited[start] = true;
        for (int i = 1; i <= nums[start]; i++) {
            int jumpTo = start + i;
            if (jumpTo >= nums.length)
                break;
            jump[start] |= dfs(jumpTo);
        }
        return jump[start];
    }

    public boolean canJumpRecursion(int[] nums) {
        this.nums = nums;
        this.jump = new boolean[nums.length];
        this.visited = new boolean[nums.length];
        this.jump[nums.length - 1] = true;
        this.visited[nums.length - 1] = true;
        return dfs(0);
    }

    public boolean canJump(int[] nums) {
        int maxJump = nums[0];
        if (maxJump >= nums.length - 1)
            return true;
        for (int i = 1; i <= maxJump; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);
            if (maxJump >= nums.length - 1)
                return true;
        }
        return false;
    }
}
