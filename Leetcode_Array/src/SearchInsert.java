/**
 * @author Bryce
 * @project Leetcode_Array
 * @date 2021/3/21
 * 题号：35
 * 题解：https://mp.weixin.qq.com/s/fCf5QbPDtE6SSlZ1yh_q8Q
 * 方法： 二分法
 * 笔记: 只要看到面试题里给出的数组是有序数组，都可以想一想是否可以使用二分法
 * 定义左闭右闭的区间 [left, right], 初始值：left = 0, right = n-1
 **/
public class SearchInsert {
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

    public static void main(String[] args) {
        int[] nums = {1, 3};
        int target = 1;
        int outcome = new SearchInsert().searchInsert(nums, target);
        System.out.println(outcome);
    }

}
