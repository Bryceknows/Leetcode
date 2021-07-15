package LinkedList;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/5/31
 * 题目：
 * 题解：
 * 方法：滑动窗口（固定窗口大小）、虚拟头结点
 * 笔记：两个指针中间隔 n 个结点，这样当 cur 走到链表末尾的 null 时，pre 刚好走到倒数第 n+1 个结点
 **/
public class M_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);  // 虚拟头结点
        dummyHead.next = head;
        ListNode pre = dummyHead, cur = dummyHead;

        // 起初 cur 和 pre 都指向第 0 个结点（dummyHead）
        for (int i = 0; i < n + 1; i++) { // 两个指针中间隔了 n 个结点
            cur = cur.next;
        } // 此时 cur 指向第 n+1 个结点

        while (cur != null) { // 让 cur 走到链表末尾的 null
            cur = cur.next;
            pre = pre.next;
        } // 此时 pre 指向到倒数第 n+1 个结点

        if (pre != null && pre.next != null) {
            pre.next = pre.next.next; // 删除 pre 后一个结点
        } else {
            return null;
        }

        return dummyHead.next;
    }
}
