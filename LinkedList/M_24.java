package LinkedList;

/**
 * @author Bryce
 * @project Leetcode
 * @date 2021/5/23
 * 题目：两两交换链表中的节点
 * 题解：
 * 方法：虚拟头结点
 * 笔记：cur 表示 cur 被赋值的结点 (赋值语句的 cur = 什么，就把 cur 当什么用)
 * [dummyHead -> node1 -> node2 -> node3] -> node4 -> node5
 * dummyHead -> node2 -> [node1 -> node3 -> node4 -> node5]
 * 四个结点一组，交换中间两个 (cur 初始指向 head)
 **/
public class M_24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);  // 虚拟头结点
        dummyHead.next = head;
        ListNode cur = new ListNode();
        cur = dummyHead;

        while (cur.next != null && cur.next.next != null) {
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;

            cur.next = node2; //dummyHead指向2
            node1.next = node2.next; //1指向3
            node2.next = node1; // 2指向1
            cur = node1; // node1成为新的dummyHead
        }
        return dummyHead.next;
    }
}
