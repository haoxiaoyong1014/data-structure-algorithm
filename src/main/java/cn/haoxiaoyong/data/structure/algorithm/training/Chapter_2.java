package cn.haoxiaoyong.data.structure.algorithm.training;

/**
 * @author haoxiaoyong
 * @date created at 上午10:18 on 2021/7/9
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 * <p>
 * 反转二叉树
 * <p>
 *
 *               1
 *           2       3
 *        4    5   6   7
 *
 *              1
 *          3      2
 *       7    6  5    4
 */
public class Chapter_2 {


    //使用递归的方式
    static TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);

        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


