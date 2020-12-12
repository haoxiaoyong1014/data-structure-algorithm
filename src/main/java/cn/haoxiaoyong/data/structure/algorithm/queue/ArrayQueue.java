package cn.haoxiaoyong.data.structure.algorithm.queue;

/**
 * @author haoxiaoyong on 2020/12/12 下午 10:55
 * e-mail: hxyHelloWorld@163.com
 * github: https://github.com/haoxiaoyong1014
 * Blog: www.haoxiaoyong.cn
 * 基于数组实现队列
 * 特性： 先进先出，队尾入队，对头出队
 */
public class ArrayQueue {

    //队列元素items ,数组大小 n
    String[] items;
    int n;
    // head表示队头下标，tail表示队尾下标
    int head;
    int tail;


    public ArrayQueue(int capacity) {
        this.items = new String[capacity];
        this.head = 0;
        this.tail = 0;
        this.n = capacity;
    }

    //入队
    public boolean enqueue(String item) {
        if (tail == n) {
            return false;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    public String dequeue() {

        if (head == tail && tail == 0) {
            return null;
        }

        if (head == 0) {
            ++head;
            return items[0];
        }
        String value = items[head];
        ++head;

        return value;
    }

}
