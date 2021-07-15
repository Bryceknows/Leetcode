package DynamicProgramming.Stock;

/**
 * @author Bryce
 * @project Leetcode
 * @package DynamicProgramming.Stock
 * @date 2021/7/1
 * 题目：买卖股票的最佳时机
 * 题解：
 * 方法：股票DP
 * 笔记：股票DP的思路：
 * 股票系列问题都要设二维数组 dp[][]，其中第一位表示第 i 天，第二位表示持股状态（需要考虑清楚有几个状态），数组元素的值表示今天现金的最大值。
 **/
public class E_121 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        //二维数组第二位为0表示不持有股票，1表示持有股票
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);  // 昨天不持股 or 昨天持股然后今天卖出
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);  // 昨天持股 or 昨天不持股然后今天买入
        }

        return dp[n - 1][0];
    }
}
