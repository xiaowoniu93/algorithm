package com.xszheng.chapter99;

import java.util.HashMap;
import java.util.Map;

/**
 * 取出数组中重复次数最多的一个数
 */
public class MostRepeat {

    public static void main(String[] args) {
        method1();
        method2();
    }

    /**
     * 时间复杂度是 O(n)
     */
    private static void method1(){
        int[] a = new int[]{1,2,3,4,4,4,5,5,5,6,7};
        Map<Integer, Integer> aMap = new HashMap<>();
        for (int i=0; i<a.length; i++){
            int val = a[i];
            if(aMap.containsKey(val)){
                aMap.put(val, aMap.get(val)+1);
            } else {
                aMap.put(val, 1);
            }
        }
        int maxCount = 0;
        int maxVal = 0;
        for (Map.Entry<Integer, Integer> entry : aMap.entrySet()){
            if(entry.getValue() > maxCount){
                maxCount = entry.getValue();
                maxVal = entry.getKey();
            }
        }
        System.out.println("出现次数最多的数字是"+maxVal+"; 总共出现"+maxCount+"次");
    }

    /**
     * 时间复杂度是 O(n^2)，空间复杂度是 O(1)
     */
    private static void method2(){
        int[] a = new int[]{1,2,3,4,4,4,5,5,5,6,7};
        int maxCount = 0;
        int maxVal = 0;
        for (int i=0; i<a.length; i++){
            int maxCountTemp = 0;
            for (int j=0; j<a.length; j++){
                if (a[i] == a[j]){
                    maxCountTemp++;
                }
                if(maxCountTemp > maxCount){
                    maxCount = maxCountTemp;
                    maxVal = a[i];
                }
            }
        }
        System.out.println("出现次数最多的数字是"+maxVal+"; 总共出现"+maxCount+"次");
    }
}
