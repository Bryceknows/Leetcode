import java.util.List;

/**
 * @author Bryce
 * @project Leetcode_LinkedList
 * @date 2021/3/24
 * 题号：206
 * 题解：https://mp.weixin.qq.com/s/pnvVP-0ZM7epB8y3w_Njwg
 * 方法：双指针法（pre和cur）
 * 笔记：
 * 设置链表的双指针：ListNode pre = null, cur = head;
 * 遍历链表的语句： while (cur != null)
 * 移动pre的语句： pre = cur; (不要用 pre = pre.next; )
 * 移动cur的语句： cur = cur.next; （先动pre后动cur！！！）
 **/
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        ListNode temp = new ListNode(0);

        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre; //此时 pre 指向反转过的链表的头结点
    }
}
