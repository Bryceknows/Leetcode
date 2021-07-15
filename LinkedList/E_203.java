package LinkedList;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/3/24
 * 题目：移除链表元素
 * 题解：
 * 方法：虚拟头结点
 * 笔记：用于链表的删除操作
 * ！！！head 指的是链表中的第一个结点，既有 next 也有 val。
 * 比如 leetcode 上给的 head = [1,2,3,4]，那么 head 就是其中的 1。
 * 虚拟头结点 dummyHead 就没有 val，只有 next。 初始化 dummyHead.next = head;
 * 遍历链表的语句： while (cur != null)
 * 移动pre的语句： pre = cur; (不要用 pre = pre.next; )
 * 移动cur的语句： cur = cur.next; （先动pre后动cur！！！）
 * 删除结点的语句： pre.next = cur.next; （让pre所指的结点 指向 cur所指的结点的下一个结点，相当于跳过了 cur所指的结点）
 * 设置虚拟头结点的三板斧：
 * ListNode dummyHead = new ListNode(0);  // 虚拟头结点
 * dummyHead.next = head;
 * ListNode pre = dummyHead, cur = dummyHead.next;
 **/
public class E_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);  // 虚拟头结点
        dummyHead.next = head;
        ListNode pre = dummyHead, cur = dummyHead.next;

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

