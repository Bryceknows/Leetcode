/**
 * @author Bryce
 * @project Leetcode_Array
 * @date 2021/3/24
 * 题号：209
 * 题解：https://mp.weixin.qq.com/s/UrZynlqi4QpyLlLhBPglyg
 * 方法：双指针法（滑动窗口）
 * 笔记：就是不断地调节子序列的起始位置和终止位置，从而得出我们要想的结果。
 * 快指针用于遍历数组。
 * 当满足一定条件时，从sum中删除慢指针的值，慢指针往前移动一格。
 **/
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        // i 为慢指针，j 为快指针
        int i = 0;
        int n = nums.length;
        int sum = 0;
        int subLength = 0; //子序列的长度
        int minSubLength = Integer.MAX_VALUE; //记录最小的子序列长度

        for (int j = 0; j < n; j++) {
            sum += nums[j];
            while (sum >= target) {
                subLength = j - i + 1; //记录此时的子序列长度
                sum -= nums[i];
                i++;
                minSubLength = minSubLength < subLength ? minSubLength : subLength;
            }
        }
        //如果 minSubLength 的值没变，说明 sum 从来没有 >= target 过，于是返回 0。
        return minSubLength == Integer.MAX_VALUE ? 0 : minSubLength;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums ={2,3,1,2,4,3};
        int outcome=new MinSubArrayLen().minSubArrayLen(target,nums);
        System.out.println(outcome);
    }
}
