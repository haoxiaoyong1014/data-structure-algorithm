package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haoxiaoyong
 * @version 1.0.0
 * @date created at 上午10:33 on 2022/11/2
 * <p>
 * 回溯 --> 全排列
 */
public class LeetCode_46 {

    static List<List<Integer>> lists = new ArrayList<>();

    static List<Integer> paths = new ArrayList<>();


    public static void backTracking(int[] nums, boolean[] used) {

        //找到结束条件
        if (paths.size() == nums.length) {
            List<Integer> results = new ArrayList<>(paths);
            lists.add(results);
            return;
        }
        //横着遍历
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            paths.add(nums[i]);
            used[i] = true;
            backTracking(nums, used);
            paths.remove(paths.size() - 1);
            used[i] = false;
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backTracking(nums, used);
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
