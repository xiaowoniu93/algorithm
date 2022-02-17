package com.xszheng;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 最长不重复子串
 * 对于给定的字符串，输出他不包含重复字符的子字符串的最大长度。
 * 例如："abcabccc" 的最长不包含重复字符的子字符串是abc或bca或cab，所以最大长度是3
 */
public class MaxNoRepeatSubStr {

    /**
     * 假定字符串仅包含字母
     * @param str
     * @return
     */
    public int calculate(String str) {
        List<String> subStrs = new ArrayList<>();
        int length = str.length();
        for(int x=0; x<length; x++) {
            StringBuilder sb = new StringBuilder();
            int[] stats = new int[26];
            for(int y=x; y<length; y++) {
                char c = str.charAt(y);
                stats[c % 26] = stats[c % 26] + 1;
                if (stats[c % 26] > 1) {
                    break;
                }
                sb.append(c);
            }
            subStrs.add(sb.toString());
        }
        subStrs.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o2.length(), o1.length());
            }
        });
        return subStrs.get(0).length();
    }

    public static void main(String[] args) {
        MaxNoRepeatSubStr instance = new MaxNoRepeatSubStr();
        System.out.println(instance.calculate("abcabcdcabde"));
    }
}
