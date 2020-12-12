package cn.haoxiaoyong.data.structure.algorithm.stack;

/**
 * @author haoxiaoyong on 2020/12/12 下午 7:49
 * e-mail: hxyHelloWorld@163.com
 * github: https://github.com/haoxiaoyong1014
 * Blog: www.haoxiaoyong.cn
 * 基于链表实现栈
 */
public class StackBasedOnLinkedList {

    private Node top;


    //放元素
    public void push(int value) {

        Node newNode = new Node(value, null);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    //取元素
    public int pop() {
        //用-1表示栈为空
        if (null == top) {
            return -1;
        }
        int value = top.getData();

        top = top.next;
        return value;
    }

    class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
