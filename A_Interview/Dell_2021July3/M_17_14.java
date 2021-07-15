package A_Interview.Dell_2021July3;

import java.util.PriorityQueue;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/7/3
 * 题目：最小K个数 【Dell笔试】
 * 题解：
 * 方法：堆排序
 * 笔记：
 **/
public class M_17_14 {
    public int[] smallestK(int[] arr, int k) {
        //特殊情况处理
        if (arr.length == 0) {
            return arr;
        }
        //避免k大于数组长度
        k = Math.min(k, arr.length);
        //堆排序，用优先队列实现
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int[] res = new int[k];
        //数组元素全部入队
        for (int i : arr) {
            queue.add(i);
        }
        //出队k个元素
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

}
