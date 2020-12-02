package cn.haoxiaoyong.data.structure.algorithm.linkedlist;

/**
 * @author haoxiaoyong
 * @date created at 下午3:16 on 2020/12/2
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 */

public class MyLinkedListDouble {

    int size;
    // sentinel nodes as pseudo-head and pseudo-tail
    ListNodeDouble head, tail;

    public MyLinkedListDouble() {

        size = 0;
        head = new ListNodeDouble(0);
        tail = new ListNodeDouble(0);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        // if index is invalid
        if (index < 0 || index >= size) return -1;

        // choose the fastest way: to move from the head
        // or to move from the tail
        ListNodeDouble curr = head;
        if (index + 1 < size - index)
            for (int i = 0; i < index + 1; ++i) curr = curr.next;
        else {
            curr = tail;
            for (int i = 0; i < size - index; ++i) curr = curr.prev;
        }

        return curr.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNodeDouble pred = head, succ = head.next;

        ++size;
        ListNodeDouble toAdd = new ListNodeDouble(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNodeDouble succ = tail, pred = tail.prev;

        ++size;
        ListNodeDouble toAdd = new ListNodeDouble(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        // If index is greater than the length,
        // the node will not be inserted.
        if (index > size) return;

        // [so weird] If index is negative,
        // the node will be inserted at the head of the list.
        if (index < 0) index = 0;

        // find predecessor and successor of the node to be added
        ListNodeDouble pred, succ;
        if (index < size - index) {
            pred = head;
            for (int i = 0; i < index; ++i) {

                pred = pred.next;
            }
            succ = pred.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index; ++i) {

                succ = succ.prev;
            }
            pred = succ.prev;
        }

        // insertion itself
        ++size;
        ListNodeDouble toAdd = new ListNodeDouble(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        // if the index is invalid, do nothing
        if (index < 0 || index >= size) return;

        // find predecessor and successor of the node to be deleted
        ListNodeDouble pred, succ;
        if (index < size - index) {
            pred = head;
            for (int i = 0; i < index; ++i) pred = pred.next;
            succ = pred.next.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index - 1; ++i) succ = succ.prev;
            pred = succ.prev.prev;
        }

        // delete pred.next
        --size;
        pred.next = succ;
        succ.prev = pred;
    }

}

class ListNodeDouble {
    int val;
    ListNodeDouble next;
    ListNodeDouble prev;

    public ListNodeDouble(int x) {
        val = x;
    }

    public static void main(String[] args) {
        MyLinkedListDouble linkedList = new MyLinkedListDouble();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.get(1)); //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));//返回3
    }
}
