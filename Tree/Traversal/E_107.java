package Tree.Traversal;

import Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/6/6
 * 题目：二叉树的层序遍历 II
 * 题解：
 * 方法：BFS
 * 笔记：把E_102得到的结果数组反转一下就行
 **/
public class E_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> realResult = new ArrayList<>();
        int layerCount = 0; //记录层数

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int n = queue.size(); //记录每层的结点个数
            List<Integer> temp = new ArrayList<>(); //记录每层的结点
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(temp);
            layerCount++;
        }

        for (int i = layerCount - 1; i >= 0; i--) {
            realResult.add(result.get(i));
        }

        return realResult;
    }
}
