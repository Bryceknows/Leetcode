package LinkedList;

import LinkedList.ListNode;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/5/23
 * 题目：环形链表
 * 题解：
 * 方法：双指针法（快慢指针）
 * 笔记：慢指针走一步，快指针走两步，如果快慢指针相遇，那链表必定有环
 **/
public class E_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head; //慢指针
        ListNode fast = head; //快指针
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next; //慢指针走一步
            fast = fast.next.next; //快指针走两步
            if (fast == slow) return true;
        }
        return false;
    }
}
