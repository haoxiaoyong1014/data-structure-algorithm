package cn.haoxiaoyong.data.structure.algorithm.leetcode;


/**
 * @author haoxiaoyong
 * @date created at 下午7:17 on 2021/7/1
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 * <p>
 * 反转链表
 */
public class LeetCode_206 {

    public static ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(0, 1);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.addAtIndex(2, 3);
        myLinkedList.addAtIndex(3, 4);
        ListNode reverse = reverse(myLinkedList.head);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }

    public static ListNode reverse(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode cx = curr.next;
            curr.next = prev;
            prev = curr;
            curr = cx;
        }
        return prev;
    }

}
