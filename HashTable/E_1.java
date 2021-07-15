package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/5/18
 * 题目：两数之和
 * 题解：
 * 方法：哈希表（HashMap实现）
 * 笔记：将 nums[i] 作为 key，将 i 作为 value。
 * 一边添加一边查找，这样避免了 key 重复（因为当前循环中的i比之前存进去的i都要大）。
 **/
public class E_1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[]{0,1};
        }

        Map<Integer, Integer> map = new HashMap<>();

        // 一边添加一边查找
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]),i};
            }
            // 查找
            map.put(nums[i], i); // 将 nums[i] 作为 key，将 i 作为 value
        }
        return new int[0];
    }
}
