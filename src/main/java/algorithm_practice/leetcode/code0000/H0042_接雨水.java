package algorithm_practice.leetcode.code0000;

import org.junit.Test;

import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class H0042_接雨水 {

    int sum(int[] height, int s, int e, int h) {
        int k = 0;
        for (int i = s + 1; i < e; i++) {
            if (height[i] < h)
                k++;
        }
        return k;
    }

    public int trapOn2(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int idLeft = height[i], idRight = height[i];
            for (int j = i; j >= 0; j--) {
                idLeft = Math.max(idLeft, height[j]);
            }
            for (int j = i; j < size; j++) {
                idRight = Math.max(idRight, height[j]);
            }
            ans += Math.min(idLeft, idRight) - height[i];
        }
        return ans;
/*
        int maxHeight = 0;

        for (int i = 0; i < height.length; i++) {
            maxHeight = Math.max(maxHeight, height[i]);
        }
        if (maxHeight == 0)
            return 0;
        int res = 0;
        int idStart = 0, idEnd = height.length - 1;
        for (int i = 0; i < maxHeight; i++) {
            while (idStart < idEnd && height[idStart] <= i)
                idStart++;
            while (idEnd > idStart && height[idEnd] <= i)
                idEnd--;
            res += sum(height, idStart, idEnd, i + 1);
        }
        return res;*/

    }

    public int trapON(int[] height) {
        if (height.length == 0)
            return 0;
        int[] idLeft = new int[height.length];
        int[] idRight = new int[height.length];
        idLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            idLeft[i] = Math.max(idLeft[i - 1], height[i]);
        }
        idRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            idRight[i] = Math.max(height[i], idRight[i + 1]);
        }
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(idLeft[i], idRight[i]) - height[i];
        }
        return ans;
    }

/*    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int size = height.length;
        int ans = 0;
        for (int i = 0; i < size; i++) {
            if (st.empty()) {
                st.push(i);
            } else {
                if (height[i] <= height[st.peek()]) {
                    st.push(i);
                } else {
                    while (true) {
                        int k = st.pop();
                        while(!st.empty()&&st.peek)
                    }
                }
            }
        }
        return ans;
    }*/

    @Test
    public void test0042() {
        int[] k = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    /*    trap(k);*/
    }
}
