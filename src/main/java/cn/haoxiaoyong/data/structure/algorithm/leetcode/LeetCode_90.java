package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haoxiaoyong
 * @version 1.0.0
 * @date created at 下午3:06 on 2022/11/25
 * 回溯 --> 子集II
 */
public class LeetCode_90 {

    static List<List<Integer>> lists = new ArrayList<>();

    static List<Integer> paths = new ArrayList<>();

    public static void backTracking(int[] nums, int startIndex, boolean[] used) {

        List<Integer> results = new ArrayList<>(paths);
        lists.add(results);

        if (startIndex == nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {

            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            paths.add(nums[i]);
            used[i] = true;
            backTracking(nums, i + 1, used);
            used[i] = false;
            paths.remove(paths.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(nums, 0, used);
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }
}
