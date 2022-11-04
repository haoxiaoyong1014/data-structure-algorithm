package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haoxiaoyong
 * @version 1.0.0
 * @date created at 下午4:05 on 2022/11/2
 * 回溯 组合总和III
 */
public class LeetCode_216 {

    static List<List<Integer>> lists = new ArrayList<>();

    static List<Integer> paths = new ArrayList<>();


    public static void backTracking(int sum, int k, int n, int startIndex) {

        //找到终止条件
        if (paths.size() == k && sum == n) {
            List<Integer> results = new ArrayList<>(paths);
            lists.add(results);
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            paths.add(i);
            sum += i;
            ++startIndex;
            backTracking(sum, k, n, startIndex);
            paths.remove(paths.size() - 1);
            sum -= i;
        }

    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(0, k, n, 1);
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));//[[1, 2, 4]]
    }
}
