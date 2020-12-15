package cn.haoxiaoyong.data.structure.algorithm.queue;

/**
 * @author haoxiaoyong
 * @date created at 下午4:20 on 2020/12/15
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 * 基于数组实现一个循环队列,在队尾添加，在对头取出
 */
public class CircularQueue {

    //items数组元素，n 数组大小
    private String[] items;
    private int n;
    private int head;
    private int tail;


    //初始化一个大小为capacity的数组
    public CircularQueue(int capacity) {
        this.items = new String[capacity];
        this.head = 0;
        this.tail = 0;
        this.n = capacity;
    }

    //入队

    public boolean enqueue(String item) {
        //判断队列是否已满
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    //出队
    public String dequeue() {

        //判断队列是否为空
        if (head == tail) {
            return null;
        }
        String item = items[head];
        head = (head + 1) % n;
        return item;
    }
}


