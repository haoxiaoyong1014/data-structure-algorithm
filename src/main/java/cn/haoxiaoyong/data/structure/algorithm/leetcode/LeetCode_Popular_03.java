package cn.haoxiaoyong.data.structure.algorithm.leetcode;

import java.util.*;

/**
 * @author haoxiaoyong
 * @date created at 上午10:25 on 2022/5/9
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 * <p>
 * 热题100之 03无重复字符的最长子串
 */
public class LeetCode_Popular_03 {


    public static int lengthOfLongestSubstring(String astr) {
        if (astr == null) {
            return 0;
        }
        if (astr.length() == 1) {
            return 1;
        }
        List<Integer> numbers = new ArrayList<>();
        char[] chars = astr.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], ++count);
            if (map.size() < count) {
                numbers.add(--count);
                map.clear();
                i = i - count;
                count = 0;
            }
        }
        if (numbers.size() == 0) {
            if (map.size() != 0) {
                return map.size();
            } else {
                return 0;
            }
        }
        return Collections.max(numbers) > map.size() ? Collections.max(numbers) : map.size();

    }

    public static void main(String[] args) {
        // " "  a  abcabcbb   bbbbb   pwwkew  abcaeufewk  aab
        System.out.println(optimizationLengthOfLongestSubstring("abcabcbb"));
    }

    public static int optimizationLengthOfLongestSubstring(String astr) {
        if (astr.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        char[] chars = astr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                start = Math.max(start, map.get(chars[i]));
            }
            max = Math.max(max, i - start + 1);
            map.put(chars[i], i + 1);
        }
        return max;
    }
}
