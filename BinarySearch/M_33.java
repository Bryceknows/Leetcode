package BinarySearch;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/6/5
 * 题目：搜索旋转排序数组
 * 题解：
 * 方法：二分法（局部有序）
 * 笔记：如果nums[mid]>=nums[0]则左半部分整体升序，右半部分局部升序；(mid算在左半边里)
 *  如果nums[mid]<nums[0]则反过来。
 **/
public class M_33 {
    public int search(int[] nums, int target) {
        int n = nums.length;

        //特殊情况
        if (n == 1) {
            if (target == nums[0]) return 0;
            else return -1;
        }

        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (target == nums[mid]) {
                return mid;
            }
            //左半部分整体升序，形如 [4,5,6,7, 8 ,9,1,2,3]
            if (nums[mid] >= nums[0]) {
                if (target <= nums[mid] && target >= nums[0]) {
                    right = mid - 1; //在左半边
                } else {
                    left = mid + 1; //在右半边
                }
            }
            //右半部分整体升序，形如 [7,8,9,1, 2 ,3,4,5,6]
            else {
                if (target > nums[mid] && target <= nums[n - 1]) {
                    left = mid + 1; //在右半边
                } else {
                    right = mid - 1; //在左半边
                }
            }
        }
        return -1;
    }
}
