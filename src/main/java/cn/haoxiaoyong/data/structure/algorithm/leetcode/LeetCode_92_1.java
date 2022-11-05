package cn.haoxiaoyong.data.structure.algorithm.leetcode;

/**
 * @author haoxiaoyong on 2021/9/11 上午 11:06
 * e-mail: hxyHelloWorld@163.com
 * github: https://github.com/haoxiaoyong1014
 * Blog: www.haoxiaoyong.cn
 */
public class LeetCode_92_1 {

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        pre.next = null;

        ListNode lastNode = rightNode.next;
        rightNode.next = null;

        pre.next = reverse(leftNode);

        leftNode.next = lastNode;
        return dummyNode.next;
    }

    private static ListNode reverse(ListNode listNode) {

        ListNode pre = null;

        while (listNode != null) {
            ListNode nextNode = listNode.next;
            listNode.next = pre;
            pre = listNode;
            listNode = nextNode;
        }
        return pre;
    }

    public static void main(String[] args) {
        // 1->4->3->2->5
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(0, 1);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.addAtIndex(2, 3);
        myLinkedList.addAtIndex(3, 4);
        myLinkedList.addAtIndex(4, 5);
        ListNode reverse = reverseBetween(myLinkedList.head.next, 2, 4);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
