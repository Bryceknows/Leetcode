package HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/5/18
 * 题目：两个数组的交集
 * 题解：
 * 方法：哈希表（HashSet实现）
 * 笔记：如果哈希值比较少、特别分散、跨度非常大，使用数组就造成空间的极大浪费。
 * 题目中规定"每个元素是唯一的，不考虑顺序"，可以使用 HashSet
 **/
public class E_349 {
    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> inter = new HashSet<>();

        //遍历数组1，存入 HashSet
        for (int i : nums1) {
            set1.add(i);
        }
        //遍历数组2，判断 HashSet 中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                inter.add(i);
            }
        }

        // 将 HashSet 转化为数组
        int[] result = new int[inter.size()];
        int j = 0;
        for (int i : inter) {
            result[j] = i;
            j++;
        }

        return result;
    }
}
