package cn.haoxiaoyong.data.structure.algorithm.queue;

import org.omg.CORBA.NO_IMPLEMENT;

/**
 * @author haoxiaoyong on 2020/12/13 下午 9:28
 * e-mail: hxyHelloWorld@163.com
 * github: https://github.com/haoxiaoyong1014
 * Blog: www.haoxiaoyong.cn
 * 基于数组实现队列(无界)
 */
public class MyLinkedListQueue {

    //private NodeQueue node;
    private NodeQueue head;
    private NodeQueue tail;

    //入队
    public boolean enqueue(int value) {

        NodeQueue newNode = new NodeQueue(value, null);
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
            return true;
        }
        tail.next = newNode;
        tail = tail.next;   //tail=newNode
        return true;
    }

    //出队
    public int dequeue() {

        if (head == null && tail == null) return -1;
        int data = head.data;
        head = head.next;//移动head指针
        return data;
    }

    class NodeQueue {
        NodeQueue next;
        int data;

        public NodeQueue(int data, NodeQueue next) {
            this.data = data;
            this.next = next;
        }
    }
}
