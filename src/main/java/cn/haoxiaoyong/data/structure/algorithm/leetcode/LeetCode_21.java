package cn.haoxiaoyong.data.structure.algorithm.leetcode;

/**
 * @author haoxiaoyong on 2021/7/3 下午 4:33
 * e-mail: hxyHelloWorld@163.com
 * github: https://github.com/haoxiaoyong1014
 * Blog: www.haoxiaoyong.cn
 * <p>
 * 合并两个有序链表
 */
public class LeetCode_21 {


    public static ListNode megerTwoListNode(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode head = new ListNode();
        ListNode p =head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            } else {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            p.next = l2;
        } else {
            p.next = l1;
        }
        return head.next;
    }

    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(0, 1);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.addAtIndex(2, 4);

        MyLinkedList myLinkedList2 = new MyLinkedList();
        myLinkedList2.addAtIndex(0, 1);
        myLinkedList2.addAtIndex(1, 3);
        myLinkedList2.addAtIndex(2, 4);


        ListNode reverse = megerTwoListNode(myLinkedList.head, myLinkedList2.head);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
