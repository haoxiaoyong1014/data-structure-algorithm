package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haoxiaoyong
 * @version 1.0.0
 * @date created at 上午9:11 on 2022/11/1
 * 回溯-->子集
 *
 * 回溯模板：
 *
 * void backtracking(参数) {
 *      存放结果;
 *     if (终止条件) {
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
        lists.add(subList);  //这个要放在终止条件上面，不然会漏掉子集（自己）
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
