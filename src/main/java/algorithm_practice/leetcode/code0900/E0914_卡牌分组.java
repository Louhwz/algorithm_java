package algorithm_practice.leetcode.code0900;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一副牌，每张牌上都写着一个整数。
 * <p>
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * <p>
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 示例 2：
 * <p>
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 3：
 * <p>
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 4：
 * <p>
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * 示例 5：
 * <p>
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 * <p>
 * 提示：
 * <p>
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E0914_卡牌分组 {

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        boolean res = false;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : deck) {
            if (hashMap.get(i) != null) {
                hashMap.put(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }
        }
        int k = -1;
        for (Map.Entry<Integer, Integer> integerEntry : hashMap.entrySet()) {
            if (k == -1) {
                k = integerEntry.getValue();
            } else {
                k = gcd(k, integerEntry.getValue());
            }
        }
        return k == 1 || k == -1 ? false : true;
    }

    @Test
    public void test0914() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 2);
        hashMap.put(3, 10);

    }
}
