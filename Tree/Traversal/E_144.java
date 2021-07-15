package Tree.Traversal;


import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/6/6
 * 题目：二叉树的前序遍历
 * 题解：
 * 方法：无特殊方法
 * 笔记：
 **/
public class E_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        preOrder(root, result);
        return result;
    }
    public static void preOrder(TreeNode root, List<Integer> result){
        if(root==null){
            return;
        }
        result.add(root.val);
        preOrder(root.left,result);
        preOrder(root.right,result);
    }
}
