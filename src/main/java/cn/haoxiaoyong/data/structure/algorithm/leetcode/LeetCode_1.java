package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author haoxiaoyong
 * @date created at 下午12:40 on 2021/7/1
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 * <p>
 * 两数之和
 */
public class LeetCode_1 {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return new int[]{0};
        }
        int[] arr = null;
        for (int i = 0; i < nums.length; i++) {
            int p = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == p) {
                    arr = new int[]{i, j};
                }
            }
        }
        return arr;
    }

    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 4};
        //int[] nums = {3, 2, 4};
        //int[] nums = {0, 4, 3, 0};
        int[] ints =twoSum1(nums,11);
        System.out.println(Arrays.toString(ints));
    }


    public static int[] twoSum2(int[] nums, int tag) {
        if (nums.length == 0) {
            return new int[]{};
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length - 1; j++) {
                int i1 = nums[i] + nums[j + 1];
                if (i1 == tag) {
                    return new int[]{i, j + 1};
                }
            }
        }
        return new int[]{};
    }
}
