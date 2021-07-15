package Tree.Traversal;

import Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/6/6
 * 题目：二叉树的层序遍历
 * 题解：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/
 * 方法：BFS
 * 笔记：BFS与层序遍历的区别是：BFS输出一个包含所有结点的一维数组，层序遍历输出一个包含每层结点的二维数组
 **/
public class E_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
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
        }
        return result;
    }
}
