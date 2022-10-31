package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haoxiaoyong
 * @version 1.0.0
 * @date created at 下午4:28 on 2022/10/28
 */
public class LeetCode_17 {

    public static List<String> letterCombinations(String digits) {

        Map<String, String[]> hashMap = new HashMap<>();
        hashMap.put("2", new String[]{"a", "b", "c"});
        hashMap.put("3", new String[]{"d", "e", "f"});
        String[] split = digits.split(",");
        for (int i = 0; i < split.length; i++) {
            String[] strings = hashMap.get(split[i]);
            for (int j = 0; j < strings.length; j++) {


            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("2,3"));
    }
}
