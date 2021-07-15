package Tree.Traversal;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/6/6
 * 题目：二叉树的后序遍历
 * 题解：
 * 方法：无特殊方法
 * 笔记：
 **/
public class E_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        postOrder(root, result);
        return result;
    }
    public static void postOrder(TreeNode root, List<Integer> result){
        if(root==null){
            return;
        }
        postOrder(root.left,result);
        postOrder(root.right,result);
        result.add(root.val);
    }
}
