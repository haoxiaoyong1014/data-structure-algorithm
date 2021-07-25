package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author haoxiaoyong on 2021/7/25 下午 7:28
 * e-mail: hxyHelloWorld@163.com
 * github: https://github.com/haoxiaoyong1014
 * Blog: www.haoxiaoyong.cn
 */
public class LeetCode_83 {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> dupSet = new LinkedHashSet<>();
        ListNode curr = head;
        while (curr != null) {

            dupSet.add(curr.val);
            curr = curr.next;
        }

        ListNode prev = head;
        Iterator<Integer> iterator = dupSet.iterator();
        while (iterator.hasNext()) {
            ListNode node = new ListNode(iterator.next());

            if (prev == null) {
                prev = node;

            } else {
                prev.next = node;
                prev = prev.next;
            }
        }
        return head.next;
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

        ListNode reverse = deleteDuplicates(myLinkedList.head.next);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }

}

