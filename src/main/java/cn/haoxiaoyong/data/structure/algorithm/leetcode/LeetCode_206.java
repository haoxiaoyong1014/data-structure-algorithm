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


    public ListNode reverseList(ListNode head) {

        ListNode p;

        while (head.next != null) {

            head = head.next;
        }
        p = head;

        return null;

    }
}
