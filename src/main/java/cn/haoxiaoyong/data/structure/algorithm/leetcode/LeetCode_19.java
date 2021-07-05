package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import javafx.beans.binding.ListBinding;

/**
 * @author haoxiaoyong
 * @date created at 下午7:18 on 2021/7/5
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 * 删除链表中第n个元素
 */
public class LeetCode_19 {


    public static ListNode removeNthFromEnd(ListNode head, int n) {


        if (head == null) {

            return null;
        }

        ListNode curr = head;
        if (n == 0) {
            curr = curr.next;
            return curr;
        }

        for (int i = 0; i < n ; i++) {
            curr = curr.next;

        }
        curr.next = curr.next.next;

        return head;
    }

    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(0, 1);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.addAtIndex(2, 3);
        myLinkedList.addAtIndex(3, 5);
        ListNode reverse = removeNthFromEnd(myLinkedList.head.next, 3);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
