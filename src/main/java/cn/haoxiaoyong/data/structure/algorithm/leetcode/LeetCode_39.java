package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haoxiaoyong on 2022/11/10 下午 11:00
 * e-mail: hxyHelloWorld@163.com
 * github: https://github.com/haoxiaoyong1014
 * Blog: www.haoxiaoyong.cn
 * <p>
 * 回溯--> 组合总和
 */
public class LeetCode_39 {


    static List<List<Integer>> lists = new ArrayList<>();

    static List<Integer> paths = new ArrayList<>();

    public static void backTracking(int[] candidates, int target, int sum, int startIndex) {

        if (sum > target) {
            return;
        }
        if (sum == target) {
            List<Integer> resultList = new ArrayList<>(paths);
            lists.add(resultList);
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            paths.add(candidates[i]);
            sum += candidates[i];
            backTracking(candidates, target, sum, i);
            paths.remove(paths.size() - 1);
            sum -= candidates[i];

        }

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTracking(candidates, target, 0, 0);
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        System.out.println(combinationSum(nums, 8));
    }

}
