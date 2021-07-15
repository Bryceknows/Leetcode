package Tree.Traversal;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/6/6
 * 题目：二叉树的中序遍历
 * 题解：
 * 方法：无特殊方法
 * 笔记：
 **/
public class E_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }
    public static void inOrder(TreeNode root, List<Integer> result){
        if(root==null){
            return;
        }
        inOrder(root.left,result);
        result.add(root.val);
        inOrder(root.right,result);
    }
}
