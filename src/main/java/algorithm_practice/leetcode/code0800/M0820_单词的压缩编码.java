package algorithm_practice.leetcode.code0800;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 * <p>
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 * <p>
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 * <p>
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入: words = ["time", "me", "bell"]
 * 输出: 10
 * 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 7
 * 每个单词都是小写字母 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/short-encoding-of-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0820_单词的压缩编码 {

    private boolean matches(String word1, String word2) {
        if (word1.length() > word2.length()) return false;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) return false;
        }
        return true;
    }

    public int minimumLengthEncodingMyOwn(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        List<String> res = new ArrayList<>();
        String[] revWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            revWords[i] = new StringBuffer(words[i]).reverse().toString();
        }
        int ans = 0;
        for (String revWord : revWords) {
            boolean skip = false;
            for (int i = 0; i < res.size(); i++) {
                if (matches(revWord, res.get(i))) {
                    skip = true;
                    break;
                }
            }
            if (!skip) {
                res.add(revWord);
                ans += revWord.length() + 1;
            }
        }
        return ans;
    }

    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (w1, w2) -> w2.length() - w1.length());
        int res = 0;
        List<String> kk = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            boolean skip = false;
            for (int j = 0; j < kk.size(); j++) {
                if (kk.get(j).contains(words[i])){
                    skip = true;
                    break;
                }
            }
            if (!skip) {
                kk.add(words[i]);
                res += words[i].length() + 1;
            }

        }
        return res;

    }

    @Test
    public void test0820() {
        String[] k = new String[]{"me", "time"};
        Comparator<? super String> cmp = null;
        Arrays.sort(k, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
    }
}
