package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author haoxiaoyong
 * @date created at 下午4:59 on 2022/5/12
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 */
public class LeetCode_4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            list.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            list.add(nums2[i]);
        }

        for (int k = 0; k < list.size(); k++) {
            for (int j = 0; j < list.size() - k - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int tmp = list.get(j);
                    Integer tmpJ = list.get(j);
                    tmpJ = list.get(j + 1);
                    Integer tmpJ1 = list.get(j + 1);
                    tmpJ1 = tmp;
                }
            }
        }
        double divide = (double) list.size() / (double) 2;
        int divideInt = (int) divide;
        String str = String.valueOf(divideInt);
        if (str.contains(".")) {
            Integer target = list.get(divideInt);
            return Double.valueOf(target);
        } else {
            BigDecimal divisor = new BigDecimal(list.get(divideInt) + list.get(divideInt - 1));
            BigDecimal tag = divisor.divide(new BigDecimal(2));
            return tag.doubleValue();
        }
    }

    public static void main(String[] args) {
        // 1 2 3 4 5 6 7 8 9
        int[] nums1 = new int[]{1, 2, 3, 4, 5};
        int[] nums2 = new int[]{6, 7, 8, 11};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
