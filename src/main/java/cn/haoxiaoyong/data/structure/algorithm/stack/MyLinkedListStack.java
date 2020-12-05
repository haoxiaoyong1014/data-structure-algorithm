package cn.haoxiaoyong.data.structure.algorithm.stack;

/**
 * @author haoxiaoyong
 * @date created at 下午3:46 on 2020/12/1
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 */

public class MyLinkedListStack {

    int size; //栈元素个数
    ListNodeStack head;  // sentinel node as pseudo-head
    int n; //栈大小

    public MyLinkedListStack(int n) {
        this.size = 0;
        this.head = new ListNodeStack(0);
        this.n = n;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get() {

        ListNodeStack curr = head;
        // index steps needed
        // to move from sentinel node to wanted index
        for (int i = 0; i < size; ++i) {
            curr = curr.next;

        }
        --size;
        return curr.val;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int val) {

        if (size > n) {
            return;
        }
        // find predecessor of the node to be added
        ListNodeStack pred = head;
        for (int i = 0; i < size; ++i) {
            pred = pred.next;
        }
        ++size;
        // node to be added
        ListNodeStack toAdd = new ListNodeStack(val);
        // insertion itself
        toAdd.next = pred.next;
        pred.next = toAdd;

    }

    public static void main(String[] args) {
        MyLinkedListStack linkedList = new MyLinkedListStack(5);
        int i = 0;
        for (; i < 6; ++i) {
            linkedList.addAtIndex(i + 1);
        }

        int j = 0;
        for (; j < 5; ++j) {
            System.out.println(linkedList.get());
        }
    }
}

class ListNodeStack {
    int val;
    ListNodeStack next;

    ListNodeStack(int x) {
        val = x;
    }
}