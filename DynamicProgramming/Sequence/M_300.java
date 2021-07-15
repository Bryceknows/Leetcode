package DynamicProgramming.Sequence;

import java.util.Arrays;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/7/13
 * 题目：最长递增子序列
 * 题解：
 * 方法：一维DP
 * 笔记：本题的dp[i]的值代表以nums[i]结尾的最长子序列长度
 * */
public class M_300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        // dp[i]的值代表以nums[i]结尾的最长子序列长度
        int[] dp = new int[n];
        Arrays.fill(dp,1);  // 每个元素都至少可以单独成为子序列，所以全置为1
        int res = dp[0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {   // 若nums[i]>nums[j]，则nums[i]可以接在以nums[i]结尾的最长子序列之后
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
