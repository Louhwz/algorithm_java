package algorithm_practice.leetcode.code0100;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0151_翻转字符串里的单词 {

    public String reverseWordsMyStyle(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; ) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            //首部全是空格
            if (i < 0)
                break;
            int strBegin = i - 1;
            //找到当前字符串的索引前置位，可能是越界值-1，也可能是0，
            while (strBegin >= 0 && s.charAt(strBegin) != ' ') {
                strBegin--;
            }
            StringBuilder stringBuffer = new StringBuilder(s.substring(strBegin + 1, i + 1));
            if (stringBuilder.length() == 0) {
                stringBuilder.append(stringBuffer.toString());
            } else {
                stringBuilder.append(" ").append(stringBuffer.toString());
            }
            i = strBegin - 1;
        }

        return stringBuilder.toString();
    }

    @Test
    public void test0151() {
        System.out.println("\\s");
    }

    public String reverseWords(String s) {
        s.trim();
        List<String> collections = Arrays.asList(s.split("\\s+"));
        Collections.reverse(collections);
        return String.join(" ", collections);

    }

}
