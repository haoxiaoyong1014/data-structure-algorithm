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


    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null) {
            return head;
        }


        ListNode newNode = new ListNode(-1);

        ListNode beforeNode = new ListNode(-1);
        ListNode afterNode = new ListNode(-1);


        //前
        ListNode beforCurNode = head;
        while (beforCurNode != null) {

            if (beforCurNode.val < left) {
                beforeNode.next = new ListNode(beforCurNode.val);
                beforeNode = beforeNode.next;
            }
            beforCurNode = beforCurNode.next;
        }
        //中
        ListNode middleCurNode = head;
        ListNode middleNode = new ListNode(-1);
        ListNode middle = middleNode;
        int count = 0;
        while (middleCurNode != null) {
            if (middleCurNode.val >= left && middleCurNode.val <= right) {
                addAtIndex(middle, count, middleCurNode.val);
                //middleNode.next = new ListNode(middleCurNode.val);
                //middleNode = middleNode.next;
                count++;
            }
            middleCurNode = middleCurNode.next;
        }

        //后
        ListNode afterCurNode = head;
        while (afterCurNode != null) {
            if (afterCurNode.val > right) {
                afterNode.next = new ListNode(afterCurNode.val);
                afterNode = afterNode.next;
            }
            afterCurNode = afterCurNode.next;
        }


        //把中间的反转
        ListNode reverseMiddleNode = middleNode.next;
        ListNode pre = null;
        while (reverseMiddleNode != null) {

            ListNode next = reverseMiddleNode.next;

            reverseMiddleNode.next = pre;

            pre = reverseMiddleNode;

            reverseMiddleNode = next;
        }


        beforeNode.next = pre;
        newNode = beforeNode;


        return newNode;
    }

    public static void main(String[] args) {
        // 1->4->3->2->5
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(0, 1);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.addAtIndex(2, 3);
        myLinkedList.addAtIndex(3, 4);
        myLinkedList.addAtIndex(4, 5);
        ListNode reverse = reverseBetween5(myLinkedList.head.next, 2, 4);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }

    public static ListNode addAtIndex(ListNode head, int index, int val) {

        ListNode pred = head;
        for (int i = 0; i < index; ++i) {

            pred = pred.next;
        }
        // node to be added
        ListNode toAdd = new ListNode(val);
        // insertion itself
        toAdd.next = pred.next;
        pred.next = toAdd;

        return pred;
    }


    public static ListNode reverseBetween1(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        pre.next = reverseLinkedList(leftNode);

        // 第 5 步：接回到原来的链表中
        //pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    private static ListNode reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static ListNode reverseBetween3(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }


    public static ListNode reverseBetween4(ListNode head, int left, int right) {

        //虚拟头节点
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode pro = temp;
        //来到 left 节点前的一个节点
        int i = 0;
        for (; i < left - 1; ++i) {
            pro = pro.next;
        }
        // 保存 left 节点前的第一个节点
        ListNode leftNode = pro;
        for (; i < right; ++i) {
            pro = pro.next;
        }
        // 保存 right 节点后的节点
        ListNode rightNode = pro.next;
        //切断链表
        pro.next = null;
        ListNode newhead = leftNode.next;
        leftNode.next = null;
        leftNode.next = rever(newhead);
        //重新接头
        newhead.next = rightNode;
        return temp.next;

    }

    //和反转链表1代码一致
    public static ListNode rever(ListNode head) {
        ListNode low = null;
        ListNode pro = head;
        while (pro != null) {
            ListNode temp = pro;
            pro = pro.next;
            temp.next = low;
            low = temp;
        }
        return low;
    }

    public static ListNode reverseBetween5(ListNode head, int left, int right) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;

        //找到left的上一个节点
        for (int i = 0; i < left - 1; i++) {

            pre = pre.next;
        }

        //找到right节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {

            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;
        //切断链表

        pre.next = null;

        rightNode.next = null;

        pre.next = rever2(leftNode);

        leftNode.next = curr;

        return dummyNode.next;

    }


    public static ListNode rever2(ListNode listNode) {

        ListNode per = null;

        ListNode next = null;

        while (listNode != null) {

            next = listNode.next;

            listNode.next = per;

            per = listNode;


            listNode = next;

        }
        return per;
    }
}
