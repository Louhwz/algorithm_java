package algorithm_practice.leetcode.code0000;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M0093_复原IP地址 {
    private List<String> res = new ArrayList<>();
    private String s;

    private void traceBack(int start, StringBuilder path, int part) {
        if (path.length() == s.length() + 3) {
            res.add(path.toString());
            return;
        }
        if (start >= s.length() || part > 3) {
            return;
        }

        /*for (int i = start; i < s.length(); i++) {*/
        for (int j = 1; j <= 3 && start + j <= s.length(); j++) {
            if (start + j + 3 - part > s.length()) {
                break;
            }

            if (start + j + 3 * (3 - part) < s.length()) {
                continue;
            }
            String tk1 = s.substring(start, Math.min(start + j, s.length()));
            if (Integer.parseInt(tk1) > 255) {
                continue;
            }
            if (tk1.length() > 1 && tk1.charAt(0) == '0') {
                continue;
            }
            path.append(tk1);
            int size = tk1.length();
            if (part < 3) {
                path.append('.');
                size++;
            }
            traceBack(start + j, path, part + 1);
            path.delete(path.length() - size, path.length());
        }
        /*}*/
    }

    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        StringBuilder stringBuilder = new StringBuilder();
        traceBack(0, stringBuilder, 0);
        return this.res;
    }

    @Test
    public void testIPAddress() {
/*        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("123456");
        System.out.println(stringBuilder);
        stringBuilder.delete(1, 1 + 3);
        System.out.println(stringBuilder);*/
/*        List<String> res = new ArrayList<>();
        res.add("123");
        res.add("123");
        System.out.println(res);*/
        System.out.println(restoreIpAddresses("1111"));

    }
}
