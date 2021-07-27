package cn.haoxiaoyong.data.structure.algorithm.leetcode;


/**
 * @author haoxiaoyong on 2021/7/25 下午 7:28
 * e-mail: hxyHelloWorld@163.com
 * github: https://github.com/haoxiaoyong1014
 * Blog: www.haoxiaoyong.cn
 */
public class LeetCode_83_2 {

    public static ListNode deleteDuplicates2(ListNode head) {

        if (head == null) {

            return null;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        ListNode prev = head;
        while (fast != null /*&& fast.next != null*/) {

            if (slow.val == fast.val) {
                ListNode dup = fast;
                slow = fast;
                fast = fast.next;
                if (dup.next == null) {
                    prev.next = null;
                }
            } else {
                prev.next = fast;
                prev = prev.next;
                slow = fast;
                fast = fast.next;
            }
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


        ListNode reverse = deleteDuplicates2(myLinkedList.head.next);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }

}

