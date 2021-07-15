package DynamicProgramming.Stock;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/7/1
 * 题目：最佳买卖股票时机含冷冻期
 * 题解：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/fei-zhuang-tai-ji-de-dpjiang-jie-chao-ji-tong-su-y/
 * 方法：股票DP
 * 笔记：这道题用到3个状态，0表示不卖出不持股，1表示持股，2表示卖出不持股。应该关注的重点不是“今天是否处于冷冻期”而是“今天是否卖出”。
 **/
public class M_309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        // 二维数组第二位为0表示不卖出不持股，1表示持股，2表示卖出不持股
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for (int i = 1; i < n; i++) {
            // 今天不卖出不持股 -> 昨天必定不持股 -> 昨天不卖出不持股 or 昨天卖出不持股
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            // 今天持股 -> 昨天持股 or 昨天不卖出不持股今天买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // 今天卖出不持股 -> 昨天持股今天卖出
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }
}
