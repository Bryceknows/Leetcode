package DoublePointer.FastAndSlow;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/6/4
 * 题目：删除有序数组中的重复项
 * 题解：
 * 方法：双指针法（快慢指针）
 * 笔记：快指针遍历数组，慢指针选择性移动
 **/
public class E_26 {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        //如果fast和slow所指的元素大小相等，则fast前进一格，slow不动
        //如果fast和slow所指的元素大小不等，则slow前进一格，把fast指的值赋值给slow
        //最后返回以slow所指元素结尾的数组长度
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
