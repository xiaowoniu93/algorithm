package com.xszheng.chapter0;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 选择问题。给定一个n个数的无序的数组、一个下标值k，返回第k个最大者
 * 注：此是第一种算法。（对数组进行逆序排序，返回下标为 k-1 的元素）
 * @author zhengxiaosun
 *
 */
public class SelectSpecifiedData {

	public static void main(String[] args) {
		Integer[] array = new Integer[]{2, 3, 5, 1, 4, 9};
		Integer data = getSpecifiedData(array, 2);
		System.out.println("data:"+data);
	}

	private static Integer getSpecifiedData(Integer[] array, int index){
		if(array.length == 0 || index > array.length){
			throw new RuntimeException("数组为空或指定下标大于数组长度");
		}
		Arrays.sort(array, new MyComparator());
		System.out.println("array:" + Arrays.toString(array));
//		for (int i = 0; i < array.length; i++) {
//			System.out.print(array[i] + "、");
//		}
//		System.out.println();
		return array[index - 1];
	}
	
	static class MyComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
//			if(o1 == null || o2 == null){
//				return 0;
//			}
//			if(o2 > o1){
//				return 1;
//			} else if(o2 < o1){
//				return -1;
//			} else {
//				return 0;
//			}
			return Integer.compare(o2, o1);
		}
		
	}
}
