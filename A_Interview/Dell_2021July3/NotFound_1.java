package A_Interview.Dell_2021July3;

import java.util.Arrays;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/7/3
 * 题目：【Dell笔试】
 * Given an array of positive integers.
 * All numbers occur even number of times except one number which occurs odd number of times.
 * Find the number in O(n) time & constant space.
 * Example:
 * Input : [1, 2, 3, 2, 3, 1, 3]
 * Output : 3
 * 题解：
 * 方法：双指针法（快慢指针）
 * 笔记：先将数组原地排序。
 * 然后用双指针法，左指针l不动，右指针r负责遍历数组，当nums[r]!=nums[r-1]时，计算r与l之间的距离就能算出这段有多少个相同的元素。
 * 如果是奇数个就找到了，直接返回nums[r]，然后令l=r，开始下一段。
 * 如果一直没有找到，说明目标元素是数组中最大的数（在最后一个），循环结束后返回num[nums.length-1]即可。
 **/
public class NotFound_1 {
    public int solution(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int l = 0;
        for (int r = 1; r < nums.length - 1; r++) {
            if (nums[r] != nums[r - 1]) {
                if ((r - l) % 2 == 1) {
                    return nums[r - 1];
                }
                l = r;
            }
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 3, 1, 3};
        int res = new NotFound_1().solution(nums);
        System.out.println(res);
    }
}
