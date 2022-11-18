package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author haoxiaoyong
 * @version 1.0.0
 * @date created at 上午9:24 on 2022/11/18
 * <p>
 * 最大子数组和
 */
public class LeetCode_53 {


    static List<Integer> lists = new ArrayList<>();

    static List<Integer> paths = new ArrayList<>();

    public static void backTracking(int[] nums, int startIndex, int sum) {

        if (startIndex == nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            sum += nums[i];
            lists.add(sum);
            backTracking(nums, ++startIndex, sum);
            i = startIndex - i;
        }
    }

    public static int maxSubArray(int[] nums) {
        backTracking(nums, 0, 0);
        return Collections.max(lists);
    }

    public static void main(String[] args) {
        // int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {-2, 1, 3, 2};
        System.out.println(maxSubArray(nums));
    }
}
