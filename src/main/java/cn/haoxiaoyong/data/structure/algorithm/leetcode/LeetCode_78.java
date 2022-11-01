package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haoxiaoyong
 * @version 1.0.0
 * @date created at 上午9:11 on 2022/11/1
 * 回溯-->子集
 */
public class LeetCode_78 {

    /**
     * 用来存放结果
     */
    static List<List<Integer>> lists = new ArrayList<>();

    /**
     * 用来存放符合条件的结果
     */
    static List<Integer> subsetList = new ArrayList<>();


    public static void backTracking(int[] nums, int startIndex) {

        List<Integer> subList = new ArrayList<>(subsetList);
        lists.add(subList);
        //找到终止条件
        if (startIndex >= nums.length) {
            return;
        }

        //for循环横向遍历
        for (int i = startIndex; i < nums.length; i++) {
            subsetList.add(nums[i]);
            ++startIndex;
            backTracking(nums, startIndex);
            subsetList.remove(subsetList.size() - 1);
        }
    }

    public static void main(String[] args) {
        //int[] nums = {2, 7, 11, 15, 4};
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }


    public static List<List<Integer>> subsets(int[] nums) {
        backTracking(nums, 0);
        return lists;
    }

}
