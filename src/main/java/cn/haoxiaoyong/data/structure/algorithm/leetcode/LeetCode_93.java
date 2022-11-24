package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haoxiaoyong
 * @version 1.0.0
 * @date created at 下午1:49 on 2022/11/24
 */
public class LeetCode_93 {


    static List<String> list = new ArrayList<>();


    public static void backTracking(String str, int startIndex, int pointNum) {

        if (pointNum == 3) {
            if (isValid(str, startIndex, str.length() - 1)) {
                list.add(str);
            }
            return;
        }
        for (int i = startIndex; i < str.length(); i++) {
            if (isValid(str, startIndex, i)) {
                str = str.substring(0, i + 1) + "." + str.substring(i + 1);
                pointNum++;
                backTracking(str, i + 2, pointNum);
                str = str.substring(0, i + 1) + str.substring(i + 2);
                pointNum--;
            } else {
                break;
            }
        }
    }


    // 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
    private static Boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        // 0开头的数字不合法
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            // 遇到⾮数字字符不合法
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            // 如果⼤于255了不合法
            if (num > 255) {
                return false;
            }
        }
        return true;
    }

    public static List<String> restoreIpAddresses(String s) {
        backTracking(s, 0, 0);
        return list;
    }

    public static void main(String[] args) {
        String str = "25525511135";
        System.out.println(restoreIpAddresses(str));
    }
}
