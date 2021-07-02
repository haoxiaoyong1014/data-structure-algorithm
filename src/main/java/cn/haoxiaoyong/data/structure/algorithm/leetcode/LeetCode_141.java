package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import java.util.HashMap;

/**
 * @author haoxiaoyong
 * @date created at 下午4:21 on 2021/7/2
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 * 检测链表中是否有环
 */
public class LeetCode_141 {


    /**
     * 借助 map
     *
     * @param head
     * @return
     */
    public boolean hasCycleByMap(ListNode head) {

        HashMap<ListNode, Integer> map = new HashMap<>();
        int pos = -1;
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            ListNode p = curr.next;
            Integer val = map.get(curr);
            if (val != null) {
                pos = val;
                return true;
            }
            map.put(curr, count);
            count++;
            curr = p;
        }
        return false;
    }

    /**
     * 使用快慢指针判断是否有环
     */
    public boolean hasCycleByFastSlow(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int pos = -1;
        int count = 0;

        if (fast == null) {
            return false;
        }
        while (fast.next != null && fast.next.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                pos = count;
                return true;
            }
            count++;
        }
        return false;
    }
}
