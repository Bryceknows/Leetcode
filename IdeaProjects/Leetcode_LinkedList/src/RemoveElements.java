/**
 * @author Bryce
 * @project Leetcode_Array
 * @date 2021/3/24
 * 题号：203
 * 题解：https://leetcode-cn.com/problems/remove-linked-list-elements/solution/yi-chu-lian-biao-yuan-su-by-leetcode/
 * 方法：虚拟头结点
 * 笔记：用于链表的删除操作
 * 遍历链表的语句： while (cur != null)
 * 移动pre的语句： pre = cur; (不要用 pre = pre.next; )
 * 移动cur的语句： cur = cur.next; （先动pre后动cur！！！）
 * 删除结点的语句： pre.next = cur.next; （让pre所指的结点 指向 cur所指的结点的下一个结点，相当于跳过了 cur所指的结点）
 * 设置虚拟头结点的三板斧：
 * ListNode dummyHead = new ListNode(0);  // 虚拟头结点
 * dummyHead.next = head;
 * ListNode pre = dummyHead, cur = head;
 **/

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);  // 虚拟头结点
        dummyHead.next = head;
        ListNode pre = dummyHead, cur = head;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;  // 删除 cur 指向的结点
            } else {
                pre = cur;  // pre 指针向前移动一格
            }
            cur = cur.next;  // cur 指针向前移动一格
        }
        return dummyHead.next;
    }
}
