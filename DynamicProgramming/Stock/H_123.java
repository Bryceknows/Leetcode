package DynamicProgramming.Stock;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/7/1
 * 题目：买卖股票的最佳时机 III
 * 题解：
 * 方法：股票DP
 * 笔记：5个状态，0不持股未卖出过，1不持股已卖出一次，2不持股已卖出两次，3持股未卖出过，4持股已卖出一次
 **/
public class H_123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][5];
        // 二维数组第二位为0不持股未卖出过，1不持股已卖出一次，2不持股已卖出两次，3持股未卖出过，4持股已卖出一次
        dp[0][0]=0;
        dp[0][1]=0;
        dp[0][2]=0;
        dp[0][3]=-prices[0];
        dp[0][4]=-prices[0];

        for(int i=1;i<n;i++){
            // 今天0不持股未卖出过 -> 昨天0不持股未卖出过 or 昨天3持股未卖出过
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][3]);
            // 今天1不持股已卖出过一次 -> 昨天1不持股已卖出一次 or 昨天3持股未卖出过今天卖出
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][3]+prices[i]);
            // 今天2不持股已卖出两次 -> 昨天2不持股已卖出两次 or 昨天4持股已卖出一次今天卖出
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][4]+prices[i]);
            // 今天3持股未卖出过 -> 昨天0不持股未卖出过今天买入 or 昨天3持股未卖出过
            dp[i][3]=Math.max(dp[i-1][0]-prices[i],dp[i-1][3]);
            // 今天4持股已卖出一次 -> 昨天1不持股已卖出一次今天买入 or 4持股已卖出一次
            dp[i][4]=Math.max(dp[i-1][1]-prices[i],dp[i-1][4]);
        }
        return Math.max(Math.max(Math.max(Math.max(dp[n-1][0],dp[n-1][1]),dp[n-1][2]),dp[n-1][3]),dp[n-1][4]);
    }
}
