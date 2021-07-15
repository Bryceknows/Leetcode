package Backtracking.Combinations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bryce
 * @project Leetcode
 * @package Backtracking.Combinations
 * @date 2021/6/28
 * 题目：组合总和 III
 * 题解：
 * 方法：回溯
 * 笔记：最下面一段注释掉了的代码没有设置sum，直接在传参的时候把target改为target-candidates[i]，更简洁
 **/
public class M_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        int sum = 0;
        //特殊情况
        backtracking(n, k, 1, path, res, sum);
        return res;
    }

    private void backtracking(int n, int k, int begin, ArrayDeque<Integer> path, List<List<Integer>> res, int sum) {
        if (path.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = begin; i <= 9; i++) {
            path.addLast(i);
            sum += i;
            backtracking(n, k, i + 1, path, res, sum);
            path.removeLast();
            sum -= i;
        }
    }


/**
 public List<List<Integer>> combinationSum3(int k, int n) {
 List<List<Integer>> res = new ArrayList<>();
 ArrayDeque<Integer> path = new ArrayDeque<>();
 int sum = 0;
 //特殊情况
 backtracking(n, k, 1, path, res);
 return res;
 }

 private void backtracking(int n, int k, int begin, ArrayDeque<Integer> path, List<List<Integer>> res) {
 if (path.size() == k) {
 if (n==0) {
 res.add(new ArrayList<>(path));
 }
 return;
 }

 for (int i = begin; i <= 9; i++) {
 path.addLast(i);
 backtracking(n-i, k, i + 1, path, res);
 path.removeLast();
 }
 }
 **/

}

