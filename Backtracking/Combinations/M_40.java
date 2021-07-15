package Backtracking.Combinations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/6/28
 * 题目：组合总和 II
 * 题解：
 * 方法：回溯+剪枝
 * 笔记：本题要求解集不能包含重复的组合，所以如何去重是本题的重点
 * 最下面一段注释掉了的代码没有设置sum，直接在传参的时候把target改为target-candidates[i]，更简洁
 **/
public class M_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);  // 因为题目要求解集不能包含重复的组合，所以先将数组排序
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

            // 因为题目要求解集不能包含重复的组合，所以加了这段代码（本题重点）
            // 这个 i>begin 是本题的精髓
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, sum, i + 1, res, path);
            sum -= candidates[i];
            path.removeLast();

        }
    }

/**
 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
 List<List<Integer>> res = new ArrayList<>();
 ArrayDeque<Integer> path = new ArrayDeque<>();
 Arrays.sort(candidates);  // 因为题目要求解集不能包含重复的组合，所以先将数组排序
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

 // 因为题目要求解集不能包含重复的组合，所以加了这段代码（本题重点）
 // 这个 i>begin 是本题的精髓
 if (i > begin && candidates[i] == candidates[i - 1]) {
 continue;
 }

 path.addLast(candidates[i]);
 backtracking(candidates, target - candidates[i], i + 1, res, path);
 path.removeLast();
 }
 }
 **/

}

