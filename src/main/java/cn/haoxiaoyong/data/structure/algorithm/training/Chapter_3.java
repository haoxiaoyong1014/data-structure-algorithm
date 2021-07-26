package cn.haoxiaoyong.data.structure.algorithm.training;

import cn.haoxiaoyong.data.structure.algorithm.leetcode.MyLinkedList;
import cn.haoxiaoyong.data.structure.algorithm.leetcode.ListNode;

/**
 * @author haoxiaoyong
 * @date created at 下午12:24 on 2021/7/23
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 * <p>
 */
public class Chapter_3 {

    /**
     * 检查链表中数据的数量如果是奇数返回中点，如果是偶数返回上中点
     *
     * @param head
     * @return
     */
    public static ListNode returnUp(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(0, 2);
        myLinkedList.addAtIndex(1, 4);
        myLinkedList.addAtIndex(2, 1);
        myLinkedList.addAtIndex(3, 5);
        myLinkedList.addAtIndex(4, 6);
        myLinkedList.addAtIndex(5, 7);
        myLinkedList.addAtIndex(6, 8);
        myLinkedList.addAtIndex(7, 9);

//        ListNode os = returnUp(myLinkedList.head.next);
        ListNode os = returnDown(myLinkedList.head.next);
        System.out.println(os.val);

    }


    /**
     * 检查链表中数据的数量如果是奇数返回中点，如果是偶数返回下中点
     *
     * @param head
     * @return
     */

    public static ListNode returnDown(ListNode head) {

        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }

        ListNode slow = head.next;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

}
