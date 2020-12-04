package cn.haoxiaoyong.data.structure.algorithm.stack;

/**
 * @author haoxiaoyong
 * @date created at 下午3:46 on 2020/12/1
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 */

public class MyLinkedListStack {

    int size;
    ListNodeStack head;  // sentinel node as pseudo-head

    public MyLinkedListStack() {
        size = 0;
        head = new ListNodeStack(0);
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get() {

        ListNodeStack curr = head;
        // index steps needed
        // to move from sentinel node to wanted index
        //for (int i = 0; i < size; ++i) {
        curr = curr.next;
        //}
        --size;
        return curr.val;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int val) {

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

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        // if the index is invalid, do nothing
        if (index < 0 || index >= size) return;

        size--;
        // find predecessor of the node to be deleted
        ListNodeStack pred = head;
        for (int i = 0; i < index; ++i) {

            pred = pred.next;
        }

        // delete pred.next
        pred.next = pred.next.next;
    }

    public static void main(String[] args) {
        MyLinkedListStack linkedList = new MyLinkedListStack();
        linkedList.addAtIndex( 1);
        linkedList.addAtIndex( 2);
        linkedList.addAtIndex( 3);
        System.out.println(linkedList.get());
        System.out.println(linkedList.get());
        System.out.println(linkedList.get());
        //linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        //System.out.println(linkedList.get(1));//返回3
    }
}

class ListNodeStack {
    int val;
    ListNodeStack next;

    ListNodeStack(int x) {
        val = x;
    }
}