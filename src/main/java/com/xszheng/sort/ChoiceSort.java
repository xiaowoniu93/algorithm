package com.xszheng.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 首先找到数组中最小的那一个元素，然后再将该元素与数组中的第一个元素交换位置
 * 再在剩下的元素中找出最小的那一个元素，然后再将该元素与数组中的第二个元素交换位置
 * 如此循环，最后实现数组的排序
 */
public class ChoiceSort {

    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 1, 9, 3, 7, 6, 5, 8};
        // 比较的总轮数
        for (int i = 0; i < array.length - 1; i++) {
            // 最小值下标
            int mIndex = i;
            // 每轮比较的次数
            for (int j = i + 1; j < array.length; j++) {
                if (array[mIndex] > array[j]) {
                    mIndex = j;
                }
            }
            // 交换位置
            if (mIndex != i) {
                int temp = array[i];
                array[i] = array[mIndex];
                array[mIndex] = temp;
            }
        }
        System.out.println("排序后：" + Arrays.toString(array));
    }
}
