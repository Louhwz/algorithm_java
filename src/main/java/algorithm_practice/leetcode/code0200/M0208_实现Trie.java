package algorithm_practice.leetcode.code0200;


/**
 * 又叫字典树
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 * <p>
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * <p>
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 说明:
 * <p>
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 */
//
//public class Trie {
//    boolean isEnd;
//
//    private final int R = 26;
//
//    Trie[] links;
//
//    /**
//     * Initialize your data structure here.
//     */
//    public Trie() {
//        links = new Trie[26];
//    }
//
//    /**
//     * Inserts a word into the trie.
//     */
//    public void insert(String word) {
//        Trie tmp = this;
//        for (char c : word.toCharArray()) {
//            if (tmp.links[c - 'a'] == null) {
//                tmp.links[c - 'a'] = new Trie();
//                tmp = tmp.links[c - 'a'];
//            } else {
//                tmp = tmp.links[c - 'a'];
//            }
//        }
//        tmp.isEnd = true;
//    }
//
//    /**
//     * Returns if the word is in the trie.
//     */
//    public boolean search(String word) {
//        Trie tmp = this;
//        for (char c : word.toCharArray()) {
//            if (tmp.links[c - 'a'] == null) return false;
//            tmp = tmp.links[c - 'a'];
//        }
//        return tmp == null ? true : tmp.isEnd;
//    }
//
//    /**
//     * Returns if there is any word in the trie that starts with the given prefix.
//     */
//    public boolean startsWith(String prefix) {
//        Trie tmp = this;
//        for (char c : prefix.toCharArray()) {
//            if (tmp.links[c - 'a'] == null) return false;
//            tmp = tmp.links[c - 'a'];
//        }
//        return  true;
//    }
//}

public class M0208_实现Trie{

}
