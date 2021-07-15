package DoublePointer.SlidingWindow;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/6/2
 * 题目：连续字符
 * 题解：
 * 方法：滑动窗口（可变窗口大小）
 * 笔记：
 **/
public class E_1446 {
    public int maxPower(String s) {
        char[] ss = s.toCharArray();
        int count = 1;
        int result = 1;
        int left = 0;

        //设置滑动窗口，窗口大小不固定，求解最大的满足条件的窗口
        for (int right = 1; right < ss.length; right++) {
            if (ss[right] != ss[left]) {
                left = right;
                count = 1;
            } else {
                count++;
            }
            result = Math.max(count, result); //记录最长长度
        }
        return result;
    }
}
