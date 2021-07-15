package HashTable;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/5/18
 * 题目：赎金信
 * 题解：
 * 方法：哈希表（数组实现）
 * 笔记：与 E_242 几乎一样
 **/
public class E_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] record = new int[26];
        char[] ss = ransomNote.toCharArray();
        char[] tt = magazine.toCharArray();

        if (ss.length > tt.length) {
            return false;
        }

        // 记录每个字母出现的频次
        for (char c : ss) {
            record[c - 'a']++;
        }
        for (char c : tt) {
            record[c - 'a']--;
        }

        for (int i : record) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}
