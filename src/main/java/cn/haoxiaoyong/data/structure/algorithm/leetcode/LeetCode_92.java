package cn.haoxiaoyong.data.structure.algorithm.leetcode;

/**
 * @author haoxiaoyong
 * @date created at 下午7:36 on 2021/9/6
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 * <p>
 * 反转链表||
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *  
 */
public class LeetCode_92 {


    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode curNode = head;
        ListNode newNode = new ListNode(-1);
        ListNode afterNode = new ListNode(-1);
        while (curNode != null) {
            if (curNode.val > left && curNode.val < right) {
                newNode.next = curNode;
            }
            curNode = curNode.next;
        }

        return afterNode.next;
    }
}
