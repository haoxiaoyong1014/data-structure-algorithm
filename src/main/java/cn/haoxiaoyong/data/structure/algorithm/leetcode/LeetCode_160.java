package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haoxiaoyong
 * @date created at 下午5:28 on 2021/9/16
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 * 判断两个链表是否相交，并返回相交的节点
 */
public class LeetCode_160 {


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();

        ListNode nodeA = reverse(headA);
        ListNode nodeB = reverse(headB);

        ListNode intersection = null;
        int count = 0;
        while (nodeA != null) {
            map.put(count, nodeA.val);
            nodeA = nodeA.next;
            count++;
        }
        int countB = 0;
        ListNode nodeBefore = null;
        while (nodeB != null) {

            Integer val = map.get(countB);
            if (val != null && val == nodeB.val) {
                nodeBefore = nodeB;
                nodeB = nodeB.next;
                countB++;
            } else {
                if (countB != 0) {
                    intersection = new ListNode(nodeBefore.val);
                }
                break;
            }
        }
        return intersection;
    }

    public static ListNode reverse(ListNode node) {

        ListNode pre = null;
        while (node != null) {
            ListNode nodeNx = node.next;
            node.next = pre;
            pre = node;
            node = nodeNx;
        }
        return pre;
    }

    public static void main(String[] args) {

        MyLinkedList myLinkedListA = new MyLinkedList();
        myLinkedListA.addAtIndex(0, 5);
        myLinkedListA.addAtIndex(1, 0);
        myLinkedListA.addAtIndex(2, 1);
        myLinkedListA.addAtIndex(3, 8);
        myLinkedListA.addAtIndex(4, 4);
        myLinkedListA.addAtIndex(5, 5);

        MyLinkedList myLinkedListB = new MyLinkedList();

        myLinkedListB.addAtIndex(0, 4);
        myLinkedListB.addAtIndex(1, 1);
        myLinkedListB.addAtIndex(2, 8);
        myLinkedListB.addAtIndex(3, 4);
        myLinkedListB.addAtIndex(4, 5);
        ListNode reverse = getIntersectionNode(myLinkedListA.head.next, myLinkedListB.head.next);
        System.out.println(reverse.val);
    }

}
