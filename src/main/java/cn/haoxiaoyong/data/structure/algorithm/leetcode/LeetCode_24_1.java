package cn.haoxiaoyong.data.structure.algorithm.leetcode;

/**
 * @author haoxiaoyong on 2021/9/12 上午 10:59
 * e-mail: hxyHelloWorld@163.com
 * github: https://github.com/haoxiaoyong1014
 * Blog: www.haoxiaoyong.cn
 */
public class LeetCode_24_1 {

    public static ListNode swapPairs(ListNode node) {

        //如果是空，或者单独节点，那就直接返回
        if(node == null || node.next == null){
            return node;
        }

        //创建一个 head 节点，用来把头结点的特殊性处理掉
        ListNode head = new ListNode(-1);
        head.next = node;

        //定义一个当前指向的节点，其实也就是链表反转中的 node 节点的作用
        ListNode cur = node;
        //定义一个前驱节点，因为需要有一个前驱节点用来后面两个节点的交换
        ListNode pre = head;
        //节点的下一个节点，同样道理，可以看出，上面图中交换的时候会用到
        ListNode next = null;

        //交换到一直没有可以交换的节点为止
        while(cur!=null && cur.next!=null){
            //先保存后面的节点，当交换完，当前节点就会移动到这里，重新开始
            next = cur.next.next;

            //交换操作，也就是把上面的两个节点，两两交换
            //第一步：前面的节点先指向下一个节点
            pre.next = cur.next;
            //第二步：让自己的下一个节点，指向自己
            cur.next.next = cur;
            //最后一步：当前节点越过下一个节点，指向下下一个
            cur.next = next;

            //上面交换完成后，指针都下移到新的节点进行交换
            pre = cur;
            cur = next;
        }
        //注意，返回的时候，需要返回 head 的下一个节点，因为 head本身就是辅助的
        return head.next;
    }
}
