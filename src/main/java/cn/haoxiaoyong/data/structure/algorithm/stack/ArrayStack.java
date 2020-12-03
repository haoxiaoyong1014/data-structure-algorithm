package cn.haoxiaoyong.data.structure.algorithm.stack;

import java.util.LinkedList;

/**
 * @author haoxiaoyong
 * @date created at 下午2:42 on 2020/12/1
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 * <p>
 * 使用数组实现栈数据结构
 * 后进者先出，先进者后出
 */
public class ArrayStack {


    //栈中元素：数组
    private String[] items;

    //元素的个数
    private int count;

    //栈的大小
    private int n;


    //申请一个大小为n的队列
    public ArrayStack(int n) {
        this.items = new String[n];
        this.count = 0;
        this.n = n;
    }


    //进栈
    public boolean push(String item) {
        //栈满
        if (count == n) {
            return false;
        }
        items[count] = item;
        ++count;
        return true;
    }

    //出栈
    public String pop() {
        // 栈为空，则直接返回null
        if (count == 0) {
            return null;
        }
        // 返回下标为count-1的数组元素，并且栈中元素个数count减一
        String item = items[count - 1];
        --count;
        return item;

    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);

        int i = 0;
        for (; i < 5; ++i) {
            arrayStack.push(i + "_item");
        }

        int j = 0;
        for (; j < 5; ++j) {
            System.out.println(arrayStack.pop());
        }
    }
}
