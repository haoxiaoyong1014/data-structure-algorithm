package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haoxiaoyong
 * @version 1.0.0
 * @date created at 下午1:38 on 2022/11/21
 * 回溯-->分隔回文串
 */
public class LeetCode_131 {

    static List<List<String>> lists = new ArrayList<>();

    static List<String> paths = new ArrayList<>();

    public static void backTracking(String str, int startIndex) {

        if (startIndex == str.length()) {
            List<String> results = new ArrayList<>(paths);
            lists.add(results);
            return;
        }

        for (int i = startIndex; i < str.length(); i++) {
            String sub1 = str.substring(startIndex, i + 1);
            if (isPalindrome(str, startIndex, i)) {
                String sub = str.substring(startIndex, i + 1);
                paths.add(sub);
            } else {
                continue;
            }
            backTracking(str, i + 1);
            paths.remove(paths.size() - 1);
        }

    }

    private static boolean isPalindrome(String str, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static List<List<String>> partition(String s) {
        backTracking(s, 0);
        return lists;
    }

    public static void main(String[] args) {
        String str = "aabc";
        System.out.println(partition(str));
    }
}
