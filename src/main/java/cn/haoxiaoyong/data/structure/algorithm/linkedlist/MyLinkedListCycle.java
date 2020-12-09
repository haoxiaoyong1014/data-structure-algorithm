package cn.haoxiaoyong.data.structure.algorithm.linkedlist;

/**
 * @author haoxiaoyong
 * @date created at 下午2:01 on 2020/12/9
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 * 判断链表中是否含有环
 */
public class MyLinkedListCycle {

    public boolean hasCycle(ListNodeCycle head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNodeCycle slow = head;
        ListNodeCycle fast = head.next;
        while (slow != fast) {

            if (fast == null || fast.next == null) {

                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}

class ListNodeCycle {
    int val;
    ListNodeCycle next;

    ListNodeCycle(int x) {
        val = x;
    }
}