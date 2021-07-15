package HashTable;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/5/18
 * 题目：有效的字母异位词
 * 题解：
 * 方法：哈希表（数组实现）
 * 笔记：用数组作为哈希表，数组下标为"键"，数组值为"值"。
 * 只包含英文字母的字符串/需要统计频次的题 适合用数组作为哈希表。
 **/
public class E_242 {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        if (ss.length != tt.length) {
            return false;
        }  //如果两个字符串长度不一样，直接返回false

        // 记录每个字母出现的频次
        for (char c : ss) {
            record[c - 'a']++;
        }
        for (char c : tt) {
            record[c - 'a']--;
        }

        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
