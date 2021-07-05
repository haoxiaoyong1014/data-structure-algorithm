package cn.haoxiaoyong.data.structure.algorithm.leetcode;

/**
 * @author haoxiaoyong
 * @date created at 下午6:53 on 2021/7/5
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 * <p>
 * 合并两个顺序链表
 */
public class LeetCode_21_1 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();
        ListNode p = head;
        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            } else {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
        }

        if (l1 == null) {
            p.next = l2;
        }
        if (l2 == null) {
            p.next = l1;
        }

        return head.next;
    }
}
