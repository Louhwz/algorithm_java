package algorithm_practice.leetcode.code0000;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class H0076_最小覆盖子串 {
    private boolean check(int[] changeable, int[] base) {
        for (int i = 0; i < 256; i++) {
            if (base[i] != 0 && changeable[i] < base[i])
                return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int[] base = new int[256];
        int[] changeable = new int[256];
        for (int i = 0; i < t.length(); i++) {
            base[(int) t.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            changeable[(int) s.charAt(i)]++;
        }
        if (!check(changeable, base))
            return "";
        int start = 0, end = s.length() - 1, len = s.length();
        while (start < s.length() && base[s.charAt(start)] == 0)
            start++;

        while (end >= 0 && base[s.charAt(end)] == 0)
            end--;
        len = end - start + 1;
        int lenS = start, lenE = end;
        for (int i = start; i <= end - t.length() + 1; i++) {
            int index = s.charAt(i);
            if (base[index] == 0) {
                changeable[index]--;
                continue;
            }
            if (base[index] == changeable[index]) {
                //从end开始倒序遍历
                int mEnd = end;
                while (mEnd >= start && (base[s.charAt(mEnd)] == 0 || changeable[s.charAt(mEnd)] > base[s.charAt(mEnd)])) {
                    changeable[s.charAt(mEnd)]--;
                    mEnd--;
                }
                if (mEnd - i + 1 < len) {
                    len = mEnd - i + 1;
                    lenS = i;
                    lenE = mEnd;
                }
                break;
            } else if (changeable[index] > base[index]) {
                int[] k2 = new int[256];
                int j;
                for (j = i; j < s.length(); j++) {
                    int in = s.charAt(j);
                    k2[in]++;

                    if (check(k2, base)) {
                        break;
                    }
                }
                if (j - i + 1 < len) {
                    len = j - i + 1;
                    lenS = i;
                    lenE = j;
                }
                changeable[index]--;
            }
        }
        return s.substring(lenS, lenE + 1);
//        for (int i = 0; i < s.length(); i++) {
//            if (base[(int) s.charAt(i)] == 0)
//                continue;
//            else {
//                int[] changeable = new int[256];
//                int counter = 0;
//                for (int j = i; j < i + t.length(); j++) {
//                    changeable
//                }
//            }
//        }
//        int end = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (check(changeable, base)) {
//                end = i;
//                break;
//            }
//            changeable[s.charAt(i)]++;
//        }
//        int start = 0;
//        for (int i = 0; i < s.length(); i++) {
//            changeable[s.charAt(i)]--;
//            if (!check(changeable, base)) {
//                start = i;
//                break;
//            }
//        }
//        return s.substring(start, end);
    }

    @Test
    public void test() {
        System.out.println(minWindow("bdab", "ab"));
        System.out.println(minWindow("ADOBECODEBANC",
                "ABC"));
        System.out.println(minWindow("CBA", "ABC"));
        System.out.println(minWindow("adobecodebancbbcaa",
                "abc"));
    }
}
