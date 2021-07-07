package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import java.util.List;

/**
 * @author haoxiaoyong
 * @date created at 下午7:18 on 2021/7/5
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 * 删除链表中倒数第n个元素
 */
public class LeetCode_19 {


    public static ListNode removeNthFromEnd(ListNode head, int n) {


        if (head == null) {

            return null;
        }

        //先反转链表
        ListNode c = head;
        ListNode pre = null;
        while (c != null) {
            ListNode cn = c.next;
            c.next = pre;
            pre = c;
            c = cn;
        }


        ListNode p = pre;
        ListNode curr = pre;
        if (n == 1) {
            curr = curr.next;
            ListNode pre1 = null;
            ListNode p1 = curr;
            while (p1 != null) {
                ListNode cn = p1.next;
                p1.next = pre1;
                pre1 = p1;
                p1 = cn;
            }
            return pre1;
        }
        for (int i = 0; i < n - 2; i++) {
            curr = curr.next;

        }
        if (curr.next == null) {
            return curr;
        }
        curr.next = curr.next.next;

        //再反转链表
        ListNode p1 = p;
        ListNode pre1 = null;
        while (p1 != null) {
            ListNode cn = p1.next;
            p1.next = pre1;
            pre1 = p1;
            p1 = cn;
        }

        return pre1;
    }

    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(0, 1);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.addAtIndex(2, 3);
        myLinkedList.addAtIndex(3, 5);
        ListNode reverse = removeNthFromEnd(myLinkedList.head.next, 4);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }


    /**
     * 使用快慢指针
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {

        //借助哨兵节点
        ListNode sentryNode = new ListNode(0);

        sentryNode.next = head;

        ListNode fast = sentryNode;
        ListNode slow = sentryNode;

        for (int i = 0; i < n + 1; i++) {
            // fast 指向待删除节点的上一个节点
            fast = fast.next;
        }
        //快慢指针各向前走一步,直到fast==null
        //当fast等于null的时候slow节点就是我们要删除的节点
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode del = slow.next;
        slow.next = del.next;
        del.next = null;
        return sentryNode.next;
    }
}
