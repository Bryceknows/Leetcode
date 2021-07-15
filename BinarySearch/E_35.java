package BinarySearch;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/3/21
 * 题目：搜索插入位置
 * 题解：
 * 方法：二分法（基础模板）
 * 笔记：本题可以作为二分法的基础模板
 *  只要看到面试题里给出的数组是有序数组，都可以想一想是否可以使用二分法
 *  定义左闭右闭的区间 [left, right], 初始值：left = 0, right = n-1
 **/
public class E_35 {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        // 定义target在左闭右闭的区间里，[left, right]
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right + 1;
    }
}
