package Backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bryce
 * @project Leetcode
 * @package Backtracking
 * @date 2021/6/28
 * 题目：组合总和 Combination Sum
 * 题解：
 * 方法：回溯
 * 笔记：这题是元素可以重复使用的，所以下一轮搜索的起点依然是 i 而非 i+1
 * 最下面一段注释掉了的代码没有设置sum，直接在传参的时候把target改为target-candidates[i]，更简洁
 **/
public class M_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        backtracking(candidates, target, 0, 0, res, path);
        return res;
    }

    void backtracking(int[] candidates, int target, int sum, int begin, List<List<Integer>> res, ArrayDeque<Integer> path) {

        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, sum, i, res, path);  //因为元素可以重复使用，所以这里下一轮搜索的起点依然是i而非i+1
            sum -= candidates[i];
            path.removeLast();
        }
    }


    /**

     public List<List<Integer>> combinationSum(int[] candidates, int target) {
     List<List<Integer>> res = new ArrayList<>();
     ArrayDeque<Integer> path = new ArrayDeque<>();
     backtracking(candidates, target, 0, res, path);
     return res;
     }

     void backtracking(int[] candidates, int target, int begin, List<List<Integer>> res, ArrayDeque<Integer> path) {

     if (target == 0) {
     res.add(new ArrayList<>(path));
     return;
     } else if (target < 0) {
     return;
     }

     for (int i = begin; i < candidates.length; i++) {
     path.addLast(candidates[i]);
     backtracking(candidates, target - candidates[i], i, res, path);  //因为元素可以重复使用，所以这里下一轮搜索的起点依然是i而非i+1
     path.removeLast();
     }
     }
     **/
}

