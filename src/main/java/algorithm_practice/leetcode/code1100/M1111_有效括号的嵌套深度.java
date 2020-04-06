package algorithm_practice.leetcode.code1100;

import org.junit.Test;

import java.util.Stack;

/**
 * 有效括号字符串 定义：对于每个左括号，都能找到与之对应的右括号，反之亦然。详情参见题末「有效括号字符串」部分。
 * <p>
 * 嵌套深度 depth 定义：即有效括号字符串嵌套的层数，depth(A) 表示有效括号字符串 A 的嵌套深度。详情参见题末「嵌套深度」部分。
 * <p>
 *  
 * <p>
 * 给你一个「有效括号字符串」 seq，请你将其分成两个不相交的有效括号字符串，A 和 B，并使这两个字符串的深度最小。
 * <p>
 * 不相交：每个 seq[i] 只能分给 A 和 B 二者中的一个，不能既属于 A 也属于 B 。
 * A 或 B 中的元素在原字符串中可以不连续。
 * A.length + B.length = seq.length
 * max(depth(A), depth(B)) 的可能取值最小。
 * 划分方案用一个长度为 seq.length 的答案数组 answer 表示，编码规则如下：
 * <p>
 * answer[i] = 0，seq[i] 分给 A 。
 * answer[i] = 1，seq[i] 分给 B 。
 * 如果存在多个满足要求的答案，只需返回其中任意 一个 即可。
 * <p>
 *  
 * ()
 * ()()
 * 示例 1：
 * <p>
 * 输入：seq = "(()())"
 * 输出：[0,1,1,1,1,0]
 * 示例 2：
 * ()()
 * ()()
 * 输入：seq = "()(())()"
 * 输出：[0,0,0,1,1,0,1,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= text.size <= 10000
 *  
 * <p>
 * 有效括号字符串：
 * <p>
 * 仅由 "(" 和 ")" 构成的字符串，对于每个左括号，都能找到与之对应的右括号，反之亦然。
 * 下述几种情况同样属于有效括号字符串：
 * <p>
 * 1. 空字符串
 * 2. 连接，可以记作 AB（A 与 B 连接），其中 A 和 B 都是有效括号字符串
 * 3. 嵌套，可以记作 (A)，其中 A 是有效括号字符串
 * 嵌套深度：
 * <p>
 * 类似地，我们可以定义任意有效括号字符串 s 的 嵌套深度 depth(S)：
 * <p>
 * 1. s 为空时，depth("") = 0
 * 2. s 为 A 与 B 连接时，depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是有效括号字符串
 * 3. s 为嵌套情况，depth("(" + A + ")") = 1 + depth(A)，其中 A 是有效括号字符串
 * <p>
 * 例如：""，"()()"，和 "()(()())" 都是有效括号字符串，嵌套深度分别为 0，1，2，而 ")(" 和 "(()" 都不是有效括号字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1111_有效括号的嵌套深度 {

    public int[] maxDepthAfterSplitStack(String seq) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        int d1 = 0, d2 = 0;
        int[] res = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                if (d1 <= d2) {
                    s1.push('(');
                    d1++;
                    res[i] = 0;
                } else {
                    s2.push('(');
                    d2++;
                    res[i] = 1;
                }
            } else {
                if (!s1.isEmpty()) {
                    s1.pop();
                    res[i] = 0;
                    d1--;
                } else {
                    s2.pop();
                    res[i] = 1;
                    d2--;
                }
            }
        }
        return res;
    }

    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        int idx = 0;
        for (char c : seq.toCharArray()) {
            res[idx++] = c == '(' ? idx & 1 : (idx + 1) & 1;
        }
        return res;
    }

}
