package cn.haoxiaoyong.data.structure.algorithm.tree;

/**
 * @author haoxiaoyong
 * @date created at 上午10:18 on 2021/7/9
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 * <p>
 * 反转二叉树
 * <p>
 * <p>
 * 1
 * 2       3
 * 4    5   6   7
 * <p>
 * 1
 * 3      2
 * 7    6  5    4
 */
public class Chapter_2 {


    //使用递归的方式
    public static Node invertTree(Node root) {

        if (root == null) {
            return null;
        }
        Node left = invertTree(root.left);

        Node right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.put(6);
        binaryTree.put(4);
        binaryTree.put(3);
        binaryTree.put(5);
        binaryTree.put(7);
        binaryTree.put(8);
        binaryTree.put(9);

        Node node = invertTree(binaryTree.tree);
        System.out.println(node);

    }

}


/*
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}*/
