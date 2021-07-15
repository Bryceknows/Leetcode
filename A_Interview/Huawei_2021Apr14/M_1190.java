package A_Interview.Huawei_2021Apr14;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/4/14
 * 题目：反转每对括号间的子串 【华为笔试】
 * 题解：
 * 方法：双指针法（快慢指针）
 * 笔记：快指针遍历数组，每当走到左括号就把慢指针给移过来，走到右括号就交换括号内字符的位置。
 **/
public class M_1190 {
    public String reverseParentheses(String s) {
        //将字符串转存入数组
        char[] c = s.toCharArray();
        int n = c.length;
        int end = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (c[i] == ')') {
                end = i; //end存储字符串中最后一个右括号的位置
                break;
            }
        }

        while (c[end] == ')') { //字符串中最后一个右括号一定是最后一个被去除的，所以作为终止条件
            int left = 0; //left指向左括号
            //最内层翻转
            for (int right = 0; right < n; right++) { //left指向右括号
                if (c[right] == '(') {
                    left = right;
                } else if (c[right] == ')') {  //遇到的第一个右括号是最内层的右括号
                    //交换最内层括号内字符位置
                    int i = left + 1, j = right - 1;
                    while (i < j) {
                        char temp = c[i];
                        c[i] = c[j];
                        c[j] = temp;
                        i++;
                        j--;
                    }
                    //去除最内层括号
                    c[right] = ' ';
                    c[left] = ' ';
                    break;
                }
            }
        }

        String res = "";
        //去空格
        for (char ch : c) {
            if (ch != ' ') {
                res += ch;
            }
        }
        return res;
    }
}

