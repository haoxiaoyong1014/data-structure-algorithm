package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haoxiaoyong
 * @version 1.0.0
 * @date created at 下午2:14 on 2022/10/31
 * 回溯-->组合
 *
 * 回溯模板：
 *
 * void backtracking(参数) {
 *     if (终止条件) {
 *         存放结果;
 *         return;
 *     }
 *
 *     for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
 *         处理节点;
 *         backtracking(路径，选择列表); // 递归
 *         回溯，撤销处理结果
 *     }
 * }
 */
public class LeetCode_77 {

    /**
     * 用来存放结果
     */
    static List<List<Integer>> lists = new ArrayList<>();

    /**
     * 用来存放符合条件的结果
     */
    static List<Integer> path = new ArrayList<>();
    //static int startIndex = 1;

    public static void backTracking(int n, int k, int startIndex) {

        //找到终止条件
        if (path.size() == k) {
            ArrayList<Integer> integers = new ArrayList<>(path);
            lists.add(integers);
            return;
        }
        //循环遍历
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            ++startIndex;
            backTracking(n, k, startIndex);
            path.remove(path.size() - 1);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n < k) {
            return lists;
        }
        backTracking(n, k, 1);
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));

    }
}
