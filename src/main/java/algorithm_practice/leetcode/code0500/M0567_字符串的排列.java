package algorithm_practice.leetcode.code0500;

import org.junit.Test;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 * <p>
 * 示例2:
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 * <p>
 * 注意：
 * <p>
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0567_字符串的排列 {
    private boolean check(int[] s2, int[] s1) {
        for (int i = 0; i < 26; i++) {
            if (s2[i] != s1[i])
                return false;
        }
        return true;
    }

    public boolean checkInclusionSlidingWindow(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1Hash = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Hash[s1.charAt(i) - 'a']++;
        }
        int[] s2Hash = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s2Hash[s2.charAt(i) - 'a']++;
        }
        if (check(s2Hash, s1Hash)) {
            return true;
        } else {
            for (int i = s1.length(); i < s2.length(); i++) {
                s2Hash[s2.charAt(i) - 'a']++;
                s2Hash[s2.charAt(i - s1.length()) - 'a']--;

                if (check(s2Hash, s1Hash))
                    return true;
            }
            return false;
        }
    }


    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1Hash = new int[26];
        int[] s2Hash = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Hash[s1.charAt(i) - 'a']++;
            s2Hash[s2.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Hash[i] == s2Hash[i])
                count++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (count == 26)
                return true;
            int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            if (s2Hash[r] == s1Hash[r])
                count--;
            if (s2Hash[l] == s1Hash[l])
                count--;
            s2Hash[r]++;
            s2Hash[l]--;
            if (s2Hash[r] == s1Hash[r])
                count++;
            if (s2Hash[l] == s1Hash[l])
                count++;
        }
        return count == 26;


    }

    @Test
    public void test() {
        System.out.println(checkInclusion("ab", "eidboaooo"));

    }
}
