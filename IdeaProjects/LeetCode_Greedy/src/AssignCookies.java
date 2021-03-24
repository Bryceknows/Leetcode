import java.util.Arrays;

/**
 * @author lzc
 * @project LeetCode_Greedy
 * @package PACKAGE_NAME
 * @date 2021/1/23
 **/
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
       Arrays.sort(g);
       Arrays.sort(s);
        int count=0;
        int start=0;
        for(int i=0;i<g.length;i++){
            for(int j=start;j<s.length;j++){
                if(s[j]>=g[i]){
                    count++;
                    start=j+1;
                    break;
                }

            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = {1,2};
        int[] s = {1,2,3};
        AssignCookies ac = new AssignCookies();
        System.out.println(ac.findContentChildren(g,s));
    }
}
