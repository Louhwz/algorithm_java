package algorithm_practice.leetcode.code0100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0139_单词拆分 {
    List<String> wordDict;

    boolean[] memo;

    boolean[] visited;

    private boolean contain(StringBuilder stringBuilder, String s) {

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != stringBuilder.charAt(i))
                return false;
        }
        return true;
    }

    private boolean dfs(StringBuilder stringBuilder) {
        if (stringBuilder.length() == 0)
            return true;
        for (int i = 0; i < wordDict.size(); i++) {
            if (contain(stringBuilder, wordDict.get(i))) {
                stringBuilder.delete(0, wordDict.get(i).length());
                if (dfs(stringBuilder))
                    return true;
                stringBuilder.insert(0, wordDict.get(i));
            }
        }

        return false;
    }

    public boolean wordBreakTLE(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        StringBuilder stringBuilder = new StringBuilder(s);
        return dfs(stringBuilder);
    }

    //dp[i] = dp[i-1] & contain(i-1,i)
    //     || dp[i-2] & contain(i-2,i)
    //     || dp[i-3] & contain(i-3,i)
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> dict = new HashSet<>(wordDict);
        //substring(0,i)是否包含wordDict
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    @Test
    public void test() {
        List<String> m = new ArrayList<>();
        m.add("b");
        //System.out.println(wordBreak("a",m));
        System.out.println(wordBreak("a", new ArrayList<String>(){
            {
                add("b");
            }
        }));
    }
}
