package DoublePointer.LeftAndRightEndpoints;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/5/19
 * 题目：反转字符串
 * 题解：
 * 方法：双指针法（左右端点指针）
 * 笔记：首尾依次交换即可
 **/
public class E_344 {
    public void reverseString(char[] s) {
        int n = s.length;
        for (int left = 0, right = n - 1; left < right; ++left, --right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }
}
