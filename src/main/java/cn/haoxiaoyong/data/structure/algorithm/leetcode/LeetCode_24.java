package cn.haoxiaoyong.data.structure.algorithm.leetcode;


/**
 * @author haoxiaoyong
 * @date created at 下午2:56 on 2021/7/8
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 * <p>
 * 链表两两反转
 */
public class LeetCode_24 {

    // 1->2->3->4

    // 2->1->4->3

    // 1->2->3->4->5

    // 2->1->4->3->5

    public static ListNode swapPairs(ListNode head) {


        // 如果当前结点为null或当前结点下一个结点为null
        // 则递归终止
        if (head == null || head.next == null)
            return head;

        // subResult是head.next.next之后的结点两两交换后的头结点
        ListNode subResult = swapPairs(head.next.next);
        ListNode headNext = head.next;
        headNext.next = head;
        head.next = subResult;
        return headNext;

    }


    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(0, 1);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.addAtIndex(2, 3);
        myLinkedList.addAtIndex(3, 4);
        //myLinkedList.addAtIndex(4, 5);
        ListNode reverse = swapPairs(myLinkedList.head.next);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
