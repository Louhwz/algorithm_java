package algorithm_practice.leetcode.code0000;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0003_无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                left = Math.max(left, hashMap.get(s.charAt(i)) + 1);
            }
            hashMap.put(s.charAt(i), i);
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstringN2(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            int j;
            for (j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    ans = Math.max(ans, j - i);
                    break;
                } else {
                    set.add(s.charAt(j));
                }
            }
            if (j == s.length())
                ans = Math.max(ans, j - i);
        }
        return ans;
    }

    @Test
    public void test() {
        lengthOfLongestSubstring("abba");
    }
}
