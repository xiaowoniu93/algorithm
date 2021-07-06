package com.xszheng.chapter99;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 判断两个字符串是不是异位词
 */
public class Anagram {

    private static boolean isAnagram1(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        return Arrays.equals(char1, char2);
    }

    // 此种方法只支持字符串里全是字母
    // 此种方法最不耗内存
    private static boolean isAnagram2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] index = new int[26];
        for (int i=0; i<str1.length(); i++) {
            index[str1.charAt(i) - 'a']++;
        }
        for (int i=0; i<str2.length(); i++) {
            index[str2.charAt(i) - 'a']--;
            if (index[str2.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    // 此种方法最耗内存
    private static boolean isAnagram3(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<str1.length(); i++) {
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0) + 1);
        }
        for (int i=0; i<str2.length(); i++) {
            map.put(str2.charAt(i), map.getOrDefault(str2.charAt(i), 0) - 1);
            if (map.get(str2.charAt(i)) < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram1("ab", "a"));
        System.out.println(isAnagram2("ab", "a"));
        System.out.println(isAnagram3("ab", "a"));
    }
}
