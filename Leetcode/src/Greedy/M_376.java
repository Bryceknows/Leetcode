package Greedy;

/**
 * @author Bryce
 * @project Leetcode
 * @package Greedy
 * @date 2021/1/23
 * 题目：摆动序列
 * 题解：
 * 方法：贪心
 * 笔记：根据贪心算法，若有连续多个数呈上升/下降趋势，就选该趋势中最后一个（最大/最小）
 * 创建一个数组diff存储相邻nums里相邻两个数的差，该数组不存储"0"（差为0的数视为同一个数）
 * 排除特殊情况后，count初始为2，遍历diff，diff中每有相邻两数异号则count++
 **/
public class M_376 {
    public int wiggleMaxLength(int[] nums) {
        //排除特殊情况
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        //创建diff数组，存储相邻nums里相邻两个数的差，该数组不存储"0"，因为0乘任何数都等于0
        int[] diff = new int[nums.length - 1];
        int diffLength = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] != nums[i]) {
                diff[diffLength] = nums[i + 1] - nums[i];
                diffLength++;
            }
        }
        //排除特殊情况
        if (diffLength == 0) {
            return 1;
        }
        if (diffLength == 1) {
            return 2;
        }
        //count初始为2
        int count = 2;
        //遍历diff数组，diff中每有相邻两数异号则count++
        for (int i = 0; i < diffLength - 1; i++) {
            if (diff[i] * diff[i + 1] < 0) {
                count++;
            }
        }
        return count;
    }
}
