package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haoxiaoyong
 * @version 1.0.0
 * @date created at 下午2:14 on 2022/10/31
 * 回溯-->组合
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
        System.out.println(combine(1, 1));

    }
}
