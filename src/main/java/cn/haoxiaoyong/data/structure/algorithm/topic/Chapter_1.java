package cn.haoxiaoyong.data.structure.algorithm.topic;

import java.util.Arrays;
import java.util.List;

/**
 * @author haoxiaoyong on 2021/6/25 下午 10:32
 * e-mail: hxyHelloWorld@163.com
 * github: https://github.com/haoxiaoyong1014
 * Blog: www.haoxiaoyong.cn
 */
public class Chapter_1 {


    public static void main(String[] args) {
        ListNode listNode = new ListNode();

    }


    void megerList(ListNode l1,ListNode l2) {
        ListNode listNode = new ListNode();
        while (l1 != null ) {
            ListNode nextNode1 = l1;
            //listNode.next = l1.next;
            //ListNode listNode1 = new ListNode(nextNode1.val, nextNode1);
            listNode = nextNode1;
            listNode = listNode.next;
            l1 = nextNode1.next;
        }

        while (l2 != null ) {
            ListNode nextNode2 = l2;
            //listNode.next = l1.next;
            ListNode listNode2 = new ListNode(nextNode2.val, nextNode2);
            listNode = listNode2;
            listNode = listNode.next;
            l2 = nextNode2.next;
        }

        System.out.println(listNode);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


}
