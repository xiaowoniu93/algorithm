package com.xszheng.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 1、从数列中取出一个数作为基准数
 * 2、将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边，完成一轮排序
 * 3、将得到的两个分区用以上方法再次排序，以此类推。
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 1, 9, 3, 7, 6, 5, 8};
        int left = 0;
        int right = array.length - 1;
        my_quick_sort(array, left, right);
        System.out.println(Arrays.toString(array));
    }

    private static void my_quick_sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int start = left;
        int end = right;
        int middle = (left + right) / 2;
        while (left < right) {
            // 从左往右逐个比较，找出比基准值大的数
            while (left < right && array[left] < array[middle]) {
                left++;
            }
            // 交换
            int temp = array[left];
            array[left] = array[middle];
            array[middle] = temp;
            middle = left;
            // 从右往左逐个比较，找出比基准值小的数
            while (left < right && array[right] > array[middle]) {
                right--;
            }
            // 交换
            temp = array[right];
            array[right] = array[middle];
            array[middle] = temp;
            middle = right;
        }
        my_quick_sort(array, start, middle - 1);
        my_quick_sort(array, middle + 1, end);
    }
}
