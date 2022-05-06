package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author haoxiaoyong
 * @date created at 上午11:19 on 2022/5/6
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 */
public class LeetCode_interview_01 {

    public static boolean isUnique(String astr) {

        char[] chars = astr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length-1; j++) {
                int k = chars[i] ^ chars[j+1];
                if (k == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "leetcod";
        System.out.println(isUnique(str));
    }
}
