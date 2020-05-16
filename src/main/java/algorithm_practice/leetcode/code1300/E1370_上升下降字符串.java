package algorithm_practice.leetcode.code1300;

public class E1370_上升下降字符串 {
    public String sortString(String s) {
        int[] hash = new int[26];
        for (char k : s.toCharArray()) {
            hash[k - 'a']++;
        }
        int counter = s.length();
        StringBuilder sb = new StringBuilder();

        while (counter > 0) {
            for (int i = 0; i < 26; i++) {
                if (hash[i] != 0) {
                    sb.append((char) (i + 'a'));
                    hash[i]--;
                    counter--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (hash[i] != 0) {
                    sb.append((char) (i + 'a'));
                    hash[i]--;
                    counter--;
                }
            }
        }
        return sb.toString();
    }
}
