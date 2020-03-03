package algorithm_practice.leetcode.code0000;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0093_复原IP地址 {
    private List<String> res = new ArrayList<String>();
    private String s;
    private void traceBack(int start, String path){

        for (int i = start; i < s.length(); i++) {
            String tk1 =
        }
    }
    public List<String> restoreIpAddresses(String s) {
        this.s = s;

        /*traceBack(0, new ArrayList<String>());*/
    }
}
