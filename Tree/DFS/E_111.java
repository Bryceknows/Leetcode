package Tree.DFS;

import Tree.TreeNode;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/6/6
 * 题目：
 * 题解：
 * 方法：DFS
 * 笔记：递归，分四种情况讨论
 **/
public class E_111 {
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        else if(root.left==null&&root.right==null)return 1;
        else if(root.left!=null&&root.right==null)return minDepth(root.left)+1;
        else if(root.left==null&&root.right!=null)return minDepth(root.right)+1;
        else return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}
