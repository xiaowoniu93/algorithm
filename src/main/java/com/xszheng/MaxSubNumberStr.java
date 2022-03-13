package com.xszheng;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，输出最长的数字子串
 * eg：a1234bc43 -> 输出1234
 * 【注：Arrays.asList() 创建的对象不支持新增、删除元素】
 */
public class MaxSubNumberStr {

    private static void execute(String originStr) {
        if (StringUtils.isBlank(originStr)) {
            return;
        }
        List<String> subStrs = new ArrayList<>();
        int length = originStr.length();
        for (int i=0; i<length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j=i; j<length; j++) {
                char c = originStr.charAt(j);
                if (Character.isDigit(c)) {
                    builder.append(c);
                } else {
                    break;
                }
            }
            if (builder.length() > 0) {
                subStrs.add(builder.toString());
            }
        }
        subStrs.sort((s1, s2) -> Integer.compare(s2.length(), s1.length()));
        System.out.println(subStrs.get(0));
    }

    public static void main(String[] args) {
        execute("11234bc43");
    }
}
