package DynamicProgramming.Stock;

/**
 * @author Bryce
 * @project Leetcode
 * @package DynamicProgramming.Stock
 * @date 2021/7/1
 * 题目：买卖股票的最佳时机含手续费
 * 题解：
 * 方法：股票DP
 * 笔记：和 E_122 唯一的区别就是在 “卖出” 的情况下减去 fee
 **/
public class M_714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        //二维数组第二位为0表示不持有股票，1表示持有股票
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);  // 昨天不持股 or 昨天持股然后今天卖出
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);  // 昨天持股 or 昨天不持股然后今天买入
        }

        return dp[n - 1][0];
    }
}
