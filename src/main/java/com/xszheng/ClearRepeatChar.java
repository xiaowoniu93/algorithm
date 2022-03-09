package com.xszheng;

import java.util.BitSet;

/**
 * 清除字符串里重复的字符
 */
public class ClearRepeatChar {

    private static void execute(String str) {
        BitSet sets = new BitSet();
        for (int i = 0; i < str.length(); i++) {
            sets.set(str.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        int size = sets.size();
        System.out.println(size);
        for (int j = 0; j < size; j++) {
            if (sets.get(j)) {
                builder.append((char)j);
            }
        }
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        execute("bbcccaa!@#!!");
    }
}
