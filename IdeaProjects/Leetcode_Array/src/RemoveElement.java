/**
 * @author Bryce
 * @project Leetcode_Array
 * @date 2021/3/21
 * 题号：27
 * 题解：https://mp.weixin.qq.com/s/wj0T-Xs88_FHJFwayElQlA
 * 方法：双指针法（快慢指针）
 * 笔记：通过快指针i和慢指针j在一个for循环下完成两个for循环的工作。
 * 快指针用于遍历数组。
 * 当遇到需要删除的值时，快指针继续移动，慢指针不动；
 * 当遇到正常值时，两个指针都移动，并修改慢指针的值；
 * 最后只需输出慢指针的索引即可。
 * 设置快慢指针的两步：
 *  int i = 0;  // 慢指针
 *  for (int j = 0; j < nums.length; j++)  // 快指针
 **/

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        //i是慢指针，j是快指针
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (val != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
