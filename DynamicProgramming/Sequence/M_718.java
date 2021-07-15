package DynamicProgramming.Sequence;

import java.util.Arrays;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/7/15
 * 题目：最长重复子数组
 * 题解：https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0718.%E6%9C%80%E9%95%BF%E9%87%8D%E5%A4%8D%E5%AD%90%E6%95%B0%E7%BB%84.md
 * 方法：二维DP
 * 笔记：本题与M_1143相似，不过那题是思路一，本题是思路二
 本题 dp[i][j] 表示公共子序列以 nums1[i-1] 和 nums2[j-1] 为结尾的最大长度。
 画图推导：num1[1,2,3,2,1], num2[3,2,1,4,7]
    i	1	2	3	2	1
 j	0	0	0	0	0	0
 3	0	0	0	1	0	0
 2	0	0	1	0	2	0
 1	0	1	0	0	0	3
 4	0	0	0	0	0	0
 7	0	0	0	0	0	0
若 nums1[i-1] == nums2[j-1]，则 dp[i][j] = dp[i-1][j-1] + 1 (继承左上角的值并加上这轮的1)
 否则必为 0 (公共子序列的最后一个数不一样肯定不行)
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
