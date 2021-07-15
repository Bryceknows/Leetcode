package DynamicProgramming.Sequence;

import java.util.Arrays;

/**
 * @author Bryce
 * @project Leetcode
 * @package DynamicProgramming.Sequence
 * @date 2021/7/15
 * 题目：最长重复子数组
 * 题解：https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0718.%E6%9C%80%E9%95%BF%E9%87%8D%E5%A4%8D%E5%AD%90%E6%95%B0%E7%BB%84.md
 * 方法：二维DP
 * 笔记：dp[i][j] 表示公共子序列以 nums1[i-1] 和 nums2[j-1] 为结尾的最大长度。
 * dp[0][0]~dp[0][1]、dp[0][0]~dp[1][0] 全都为0。
 **/
public class M_718 {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = 0;
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

}
