package DoublePointer.SlidingWindow;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/6/4
 * 题目：定长子串中元音的最大数目
 * 题解：
 * 方法：滑动窗口（固定窗口大小）
 * 笔记：
 **/
public class M_1456 {
    public int maxVowels(String s, int k) {
        char[] ss = s.toCharArray();
        int sum = 0;
        int result = 0;

        //先统计前k个有多少个元音字母
        for (int i = 0; i < k; i++) {
            if (ss[i] == 'a' || ss[i] == 'e' || ss[i] == 'i' || ss[i] == 'o' || ss[i] == 'u') {
                sum++;
            }
        }
        result = sum;

        //特殊情况
        if (ss.length == 1) return result;

        //每次滑动完窗口后，如果前一个是元音sum就-1，如果新加入的是元音sum就+1
        for (int left = 1, right = k; right < ss.length; left++, right++) {
            if (ss[left - 1] == 'a' || ss[left - 1] == 'e' || ss[left - 1] == 'i' || ss[left - 1] == 'o' || ss[left - 1] == 'u') {
                sum--;
            }
            if (ss[right] == 'a' || ss[right] == 'e' || ss[right] == 'i' || ss[right] == 'o' || ss[right] == 'u') {
                sum++;
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}
