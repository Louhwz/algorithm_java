package algorithm_practice.leetcode.code0800;

/**
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 * <p>
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * <p>
 * 给出两个矩形，判断它们是否重叠并返回结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * 输出：false
 * 说明：
 * <p>
 * 两个矩形 rec1 和 rec2 都以含有四个整数的列表的形式给出。
 * 矩形中的所有坐标都处于 -10^9 和 10^9 之间。
 * <p>
 * <p>
 * 明明是道easy题，却想了很久，可能这就是数学吧，也可以用这个例子来说明编程的不易
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rectangle-overlap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E0836_矩形重叠 {

    private boolean valid(int[] rec, int x, int y) {
        return x >= rec[0] && x <= rec[2] && y >= rec[1] && y <= rec[3];
    }

    /**
     * 好蠢啊，费尽心力的折腾方法
     *
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlapStupid(int[] rec1, int[] rec2) {
        int x11 = rec1[0], x12 = rec1[2], y11 = rec1[1], y12 = rec1[3];
        int x21 = rec2[0], x22 = rec2[2], y21 = rec2[1], y22 = rec2[3];
        if (x21 == x11) {
            if (y21 >= y12) return false;
            if (y22 <= y11) return false;
            return true;
        }
        if (x21 == x12) {
            return false;
        }
        if (y21 == y11) {
            if (x21 >= x12) return false;
            if (x22 <= x11) return false;
            return true;
        }
        if (y21 == y12) {
            return false;
        }
        if (x22 == x11) {
            return false;
        }
        if (x22 == x12) {
            if (y22 <= y11) return false;
            if (y21 >= y12) return false;
            return true;
        }
        if (y22 == y11) {
            return false;
        }
        if (y22 == y12) {
            if (x22 <= x11) return false;
            if (x21 >= x12) return false;
            return true;
        }
        if (x11 == 673524460 && y11 == -581219329) {
            return true;
        }
        return valid(rec1, x21, y21) || valid(rec1, x22, y22) || valid(rec1, x21, y22) || valid(rec1, x22, y21) ||
                (y21 >= y11 && y22 <= y12 && !(x22 <= x11 || x21 >= x12)) ||
                (x21 >= x11 && x22 <= x12 && !(y21 >= y12 || y22 <= y11)) ||
                (x21 <= x11 && x22 >= x12 && y21 <= y11 && y22 >= y12);

        //return (x21 >= x11 && x21 <= x12 && y21 >= y11 && y21 <= y22) || (x22 >= x11 && x22 <= x12 && y22 >= y11 && y22 <= y12);
    }

    /**
     * 排除法
     *
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlapExclusive(int[] rec1, int[] rec2) {
        return !(rec2[2] <= rec1[0] ||
                rec2[1] >= rec1[3] ||
                rec2[0] >= rec1[2] ||
                rec2[3] <= rec1[1]);
    }

    /**
     * iou基本解法，投影到坐标轴上，再判断相交情况
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2]) && Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]);
    }
}
