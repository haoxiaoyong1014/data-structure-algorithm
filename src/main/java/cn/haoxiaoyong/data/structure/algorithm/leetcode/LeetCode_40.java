package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haoxiaoyong
 * @version 1.0.0
 * @date created at 下午2:51 on 2022/11/18
 * 回溯--> 组合总和II
 */
public class LeetCode_40 {


    static List<List<Integer>> lists = new ArrayList<>();

    static List<Integer> paths = new ArrayList<>();

    public static void backTracking(int[] nums, int startIndex, int target, int sum, boolean[] used) {

        //找到终止条件
        if (sum > target) {
            return;
        }

        if (sum == target) {
            List<Integer> resultList = new ArrayList<>(paths);
            lists.add(resultList);
            return;
        }
        // 横向遍历
        for (int i = startIndex; i < nums.length; i++) {
            //去重,前提是排序
            if (i > startIndex && nums[i - 1] == nums[i]/* && !used[i - 1]*/) {
                continue;
            }
            paths.add(nums[i]);
            sum += nums[i];
           // used[i] = true;
            // 纵向递归遍历
            backTracking(nums, i + 1, target, sum, used);
            //回溯
            sum -= nums[i];
           // used[i] = false;
            paths.remove(paths.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        boolean[] used = new boolean[candidates.length];
        Arrays.sort(candidates);
        backTracking(candidates, 0, target, 0, used);
        return lists;
    }

    public static void main(String[] args) {
        //int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int[] nums = {1,2,2};
        System.out.println(combinationSum2(nums, 3));
    }
}
