package DoublePointer.LeftAndRightEndpoints;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/6/4
 * 题目：有序数组的平方
 * 题解：
 * 方法：双指针法（左右端点指针）
 * 笔记：左右指针分别向中间靠近
 **/
public class E_977 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int[] result = new int[n];
        int index = n - 1;

        //原数组是平方数两边向中间递减
        //每次比较最左边和最右边的，大的存入数组最后一位，同时那边的指针向中间移动一格
        while (left < right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index] = nums[left] * nums[left];
                left++;
            } else {
                result[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }

        //把最后剩下的那个数（left==right时）放到result数组的第一个
        result[0] = nums[left] * nums[left];

        return result;
    }
}
