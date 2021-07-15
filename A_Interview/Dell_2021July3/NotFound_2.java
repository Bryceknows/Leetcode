package A_Interview.Dell_2021July3;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/7/3
 * 题目：【Dell笔试】
 * In a diagram, there are 2 group of ports stands in 2 vertical lines.
 * For each group of ports, we named them by the index from top to bottom.
 * The index starts from 0. Between the 2 groups of ports, there are connection lines.
 * A two-dimensional array is used to describe those connection lines.
 * In the array, each element stands for a connection line.
 * And each connection line is an array consist of left port number and right port number.
 * Given the number of ports in each line and the connection array, please calculate how many intersection points are in the diagram.
 * （Duplicated intersection point can be count multiple times）
 * Input: 4, [[0,1],[1,2],[3,0]]
 * 题解：
 * 方法：无特殊方法
 * 笔记：
 **/
public class NotFound_2 {
    public int solution(int n, int[][] nums) {
        int count = 0; //计数
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                // 这个if语句是产生intersection point点条件
                if ((nums[i][0] - nums[j][0]) * (nums[i][1] - nums[j][1]) < 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
