package Tree;

import Tree.TreeNode;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/6/6
 * 题目：翻转二叉树
 * 题解：
 * 方法：递归
 * 笔记：
 **/
public class E_226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }

        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
