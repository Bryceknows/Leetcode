package DynamicProgramming.Sequence;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/7/15
 * 题目：最长公共子序列
 * 题解：
 * 方法：二维DP
 * 笔记：本题与M_718相似，不过那题是思路二，本题是思路一
 本题 dp[i][j] 表示dp[i][j] 表示 num1 的前 i-1 个，num2 的前 j-1 个的最优解。
画图推导：text1 = "acade", text2 = "eac"
    i	a	c	a	d	e
 j	0	0	0	0	0	0
 e	0	0	0	0	0	1
 a	0	1	1	1	1	1
 c	0	0	2	2	2	2
若 nums1[i-1] == nums2[j-1]，则 dp[i][j] = dp[i-1][j-1] + 1 (这轮比较的两个数被用于+1了，不能重复计算，所以继承的是左上角的值)
 否则 dp[i][j] = max(dp[i-1][j], dp[i][j-1]) （继承上边或者左边的值）
 而且每轮循环最后要加上 dp[i][j] = min(dp[i][j], min(i, j))
 **/
public class M_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] nums1 = text1.toCharArray();
        char[] nums2 = text2.toCharArray();

        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = 0;
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
//                res = Math.max(res, dp[i][j]);
            }
        }
//        return res;
        //本题由于 dp 数组的值一定是递增的，所以不需要设变量记录最大值（当然设了也没事...）
        return dp[nums1.length][nums2.length];
    }
}
