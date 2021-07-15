package Stack;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/6/9
 * 题目：删除字符串中的所有相邻重复项
 * 题解：
 * 方法：栈
 * 笔记：
 **/
public class E_1047 {
    public String removeDuplicates(String s) {

        char[] stack = new char[s.length()];
        int size = s.length(), top = -1;

        for (char c : s.toCharArray()) {
            if (top == -1 || stack[top] != c) {
                stack[++top] = c;
            } else {
                top--;
            }
        }

        return String.valueOf(stack, 0, top + 1);
    }
}
