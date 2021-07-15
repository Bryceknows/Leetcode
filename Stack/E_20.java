package Stack;

import java.util.LinkedList;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/6/9
 * 题目：有效的括号
 * 题解：
 * 方法：栈
 * 笔记：
 **/
public class E_20 {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for(char c:s.toCharArray()){
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                char p =' ';
                if (c == ')') {
                    p = '(';
                } else if (c == ']') {
                    p = '[';
                } else if (c == '}') {
                    p = '{';
                }
                if (p != stack.pop()) {
                    return false;
                }
            }
        }

        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
