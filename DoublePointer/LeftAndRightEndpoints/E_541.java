package DoublePointer.LeftAndRightEndpoints;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/5/19
 * 题目：反转字符串 II
 * 题解：
 * 方法：双指针法（左右端点指针）
 * 笔记：right = Math.min(i + k - 1, n - 1) 这句话是为了处理 "如果剩余字符少于 k 个，则将剩余字符全部反转"
 **/
public class E_541 {
    public String reverseStr(String s, int k) {
        char[] ss = s.toCharArray();
        int n = ss.length;
        for (int i = 0; i < n; i += 2 * k) {
            for (int left = i, right = Math.min(i + k - 1, n - 1); left < right; left++, right--) {
                char temp = ss[left];
                ss[left] = ss[right];
                ss[right] = temp;
            }
        }
        return new String(ss);
    }
}
