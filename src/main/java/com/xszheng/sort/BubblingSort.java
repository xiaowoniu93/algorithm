package com.xszheng.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubblingSort {

    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 1, 9, 3, 7, 6, 5, 8};
        // 比较的总轮数
        for (int i = 0; i < array.length - 1; i++) {
            boolean isComplete = true;
            // 每轮比较的次数
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isComplete = false;
                }
            }
            // 没有交换过元素说明排序已经结束
            if (isComplete) break;
        }
        System.out.println("排序后：" + Arrays.toString(array));
    }
}
