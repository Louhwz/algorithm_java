package algorithm_practice.leetcode.code1000;

import org.junit.Test;

public class E1071_字符串的最大公因子 {


    @Test
    public void test1071() {
        System.out.println(gcd(17, 7));
        System.out.println(gcd(7, 17));
        System.out.println(gcd(8, 12));
        System.out.println(gcd(24, 3));
        System.out.println(gcd(3, 24));
    }


    private int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }

    private boolean stringDivision(String s1, String s2, String res) {
        int l = res.length();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != res.charAt(i % l)) {
                return false;
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) != res.charAt(i % l)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 枚举所有符合长度要求的前缀
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Math.min(str1.length(), str2.length()) && str1.charAt(i) == str2.charAt(i); i++) {
            stringBuilder.append(str1.charAt(i));
        }
        String prefix = stringBuilder.toString();
        if (prefix.length() != Math.min(str1.length(), str2.length())) {
            return "";
        }
        int _gcd = gcd(str1.length(), str2.length());
        for (int i = _gcd; i > 0; i--) {
            if (str1.length() % i != 0 || str2.length() % i != 0) {
                continue;
            }
            String res = prefix.substring(0, i);
            if (stringDivision(str1, str2, res)) {
                return res;
            }
        }
        return "";

    }
}
