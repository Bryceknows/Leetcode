package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/5/18
 * 题目：四数相加 II
 * 题解：https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0454.四数相加II.md
 * 方法：哈希表（HashMap），把相加问题转化成相等问题，从而使用哈希表
 * 笔记：看到形如：A+B....+N=0的式子，要转换为(A+...T) = -((T+1)...+N)再计算。
 * 这个T的分割点一般是一半，特殊情况下需要自行判断。定T是解题的关键。
 **/
public class M_454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        Map<Integer, Integer> map12 = new HashMap<>();

        //本题思路：num1 + nums2 = -(nums3 + nums4)
        // 将nums1和nums2中的元素两两相加，求得的值存入key，相同值的出现频次存入value
        for (int i : nums1) {
            for (int j : nums2) {
                if (map12.containsKey(i + j)) {
                    map12.replace(i + j, map12.get(i + j) + 1);
                } else {
                    map12.put(i + j, 1);
                }
            }
        }

        // 将nums3和nums4中的元素两两相加，取负，直接看map12中有没有相同的值
        for (int i : nums3) {
            for (int j : nums4) {
                if(map12.containsKey(-(i+j))){
                    result+=map12.get(-(i+j));
                }
            }
        }
        return result;
    }
}
