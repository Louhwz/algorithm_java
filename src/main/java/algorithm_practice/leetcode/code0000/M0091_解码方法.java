package algorithm_practice.leetcode.code0000;

import org.junit.Test;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0091_解码方法 {

    @Test
    public void testGrammar() {
        numDecodings("226");
    }

    //     2 3 1 2
    //dp:  1 1 1 3
    //2 3 1 2 // 2 3 12
    //     2 2 2 2    2
    //13
    //2 2 2 2 2, 22 2 2 2, 22 22 2, 22 2 22, 2 22 2 2, 2 22 22, 2 2 22 2, 2 2 2 22,  8
    //2 2 2 2, 22 2 2, 22 22, 2 22 2, 2 2 22    5
    //2 2 2, 22 2, 2 22    3
    //2 2, 22   2
    //2   1
    //2 9 9
    //2
    //2 9
    //2 9 9
    public int numDecodings(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int[] dp = new int[s.length()];
        if (s.charAt(0) == '0') {
            return 0;
        }
        int pre = 1, curr = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    int temp = pre;
                    pre = curr;
                    curr = temp;
                } else {
                    return 0;
                }
            }
           else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6')) {
               int temp = curr + pre;
               pre = curr;
               curr = temp;
           }
           else {
                pre = curr;

            }
        }
        return curr;

    }

    private boolean qualified(String s) {
        return Integer.parseInt(s) <= 26 && Integer.parseInt(s) >= 0;
    }
}
