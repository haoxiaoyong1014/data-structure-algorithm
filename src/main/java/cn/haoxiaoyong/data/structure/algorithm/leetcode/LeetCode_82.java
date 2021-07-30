package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haoxiaoyong on 2021/7/27 下午 10:59
 * e-mail: hxyHelloWorld@163.com
 * github: https://github.com/haoxiaoyong1014
 * Blog: www.haoxiaoyong.cn
 */
public class LeetCode_82 {

    public static ListNode deleteDuplicates(ListNode head) {

        Map<ListNode, Integer> map = new HashMap<>();

        while (head != null) {
            if (map.get(head) != null) {

            }
        }
        return null;
    }

    public static ListNode deleteDuplicates3(ListNode head) {

        //ListNode prev = new ListNode(0);
        ListNode prev = head;

        ListNode slow = head;
        ListNode fast = head.next;
        ListNode gr = head.next.next;

        while (gr != null) {
            if (slow.val == fast.val) {
                slow = slow.next;
                fast = fast.next;
                gr = gr.next;
            }
            if (fast.val == gr.val) {
                slow = slow.next;
                fast = fast.next;
                gr = gr.next;
            }
            prev.next = fast;
            prev = prev.next;
            slow = slow.next;
            fast = fast.next;
            gr = gr.next;

        }
        return head;
    }

    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(0, -3);
        myLinkedList.addAtIndex(1, -1);
        myLinkedList.addAtIndex(2, 0);
        myLinkedList.addAtIndex(3, 0);
        myLinkedList.addAtIndex(4, 0);
        myLinkedList.addAtIndex(5, 3);
        myLinkedList.addAtIndex(6, 3);
        myLinkedList.addAtIndex(7, 4);
        myLinkedList.addAtIndex(8, 5);
        /*myLinkedList.addAtIndex(9, 5);*/


        ListNode reverse = deleteDuplicates3(myLinkedList.head.next);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }

}
