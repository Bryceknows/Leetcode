package Greedy;

import java.util.Arrays;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/6/29
 * 题目：分发饼干
 * 题解：
 * 方法：贪心
 * 笔记：
 **/
public class E_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gg = 0;
        for (int ss = 0; ss < s.length; ss++) {
            if (gg == g.length) {
                break;
            }
            if (s[ss] >= g[gg]) {
                gg++;
            }
        }
        return gg;
    }
}