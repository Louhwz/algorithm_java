package algorithm_practice.leetcode.code0500;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * 你的面前有一堵方形的、由多行砖块组成的砖墙。 这些砖块高度相同但是宽度不同。你现在要画一条自顶向下的、穿过最少砖块的垂线。
 * <p>
 * 砖墙由行的列表表示。 每一行都是一个代表从左至右每块砖的宽度的整数列表。
 * <p>
 * 如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你需要找出怎样画才能使这条线穿过的砖块数量最少，并且返回穿过的砖块数量。
 * <p>
 * 你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入: [[1,2,2,1],
 * [3,1,2],
 * [1,3,2],
 * [2,4],
 * [3,1,2],
 * [1,3,1,1]]
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 每一行砖块的宽度之和应该相等，并且不能超过 INT_MAX。
 * 每一行砖块的数量在 [1,10,000] 范围内， 墙的高度在 [1,10,000] 范围内， 总的砖块数量不超过 20,000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/brick-wall
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0554_砌墙 {
    public int leastBricks(List<List<Integer>> wall) {


        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;
        for (List<Integer> list : wall) {
            count = 0;
            for (Integer integer : list) {
                count += integer;
                hashMap.put(count, hashMap.getOrDefault(count, 0) + 1);
            }
        }
        hashMap.remove(count);
        if (hashMap.isEmpty()) {
            return wall.size();
        }
        int key = hashMap.keySet().iterator().next();
        for (Integer integer : hashMap.keySet()) {
            if (hashMap.get(integer) > hashMap.get(key))
                key = integer;
        }
        return wall.size() - hashMap.get(key);
    }

    @Test
    public void test() {

    }
}
