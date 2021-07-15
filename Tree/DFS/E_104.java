package Tree.DFS;

import Tree.TreeNode;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/6/6
 * 题目：二叉树的最大深度
 * 题解：
 * 方法：DFS
 * 笔记：递归，每个结点的最大深度 = max{其左孩子最大深度，其右孩子最大深度} + 1
 **/
public class E_104 {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
