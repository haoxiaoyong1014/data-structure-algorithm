package cn.haoxiaoyong.data.structure.algorithm.tree;

/**
 * @author haoxiaoyong
 * @date created at 下午7:10 on 2021/6/8
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 */
public class BinaryTree {


    public Node tree;


    public void delete(int data) {

        Node p = tree;

        Node pp = null;
        while (p != null && data != p.data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p == null) {
            return;
        }

        //找到要删除的节点之后，分3种情况，1，要删除的节点只有左节点或者右节点，2，该节点没有子节点 3，左右节点都有的情况

        if (p.right != null && p.left != null) {

            //找到当前节点右节点中最小的节点
            Node minP = p.right;
            //minP的父节点
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }

            //到这里就是找到最小节点，以及最小节点的父节点

            //替换
            p.data = minP.data;


        }

        Node child;

        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        if (pp == null) { //删除的是跟节点
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }

    }

    public Node find(int data) {

        Node p = tree;
        while (p != null) {
            if (data == p.data) {
                return p;
            }
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        return null;
    }

    public void put(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }


}
    class Node {
        //节点数据
        int data;
        //左子树
        Node left;
        //右子树
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
