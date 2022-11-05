package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haoxiaoyong
 * @version 1.0.0
 * @date created at 下午4:28 on 2022/10/28
 * 回溯-电话号码组合
 */
public class LeetCode_17 {

    static Map<Character, String[]> hashMap = new HashMap<>();

    static List<String> lists = new ArrayList<>();

    static List<String> paths = new ArrayList<>();

    static void putData() {
        hashMap.put('2', new String[]{"a", "b", "c"});
        hashMap.put('3', new String[]{"d", "e", "f"});
        hashMap.put('4', new String[]{"g", "h", "i"});
        hashMap.put('5', new String[]{"j", "k", "l"});
        hashMap.put('6', new String[]{"m", "n", "o"});
        hashMap.put('7', new String[]{"q", "p", "r", "s"});
        hashMap.put('8', new String[]{"t", "u", "v"});
        hashMap.put('9', new String[]{"w", "x", "y", "z"});
    }

    public static void backTracking(String digits, int startIndex) {

        char[] chars = digits.toCharArray();
        if (paths.size() == chars.length) {
            StringBuffer target = new StringBuffer();
            for (int k = 0; k < paths.size(); k++) {
                target.append(paths.get(k));
            }
            lists.add(target.toString());
            return;
        }
        for (int i = startIndex; i < chars.length; i++) {
            ++startIndex;
            String[] str = hashMap.get(chars[i]);
            for (int j = 0; j < str.length; j++) {
                paths.add(str[j]);
                backTracking(digits, startIndex);
                paths.remove(paths.size() - 1);
            }
        }
    }

    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        putData();
        backTracking(digits, 0);
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }
}
