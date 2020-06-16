package com.xszheng.chapter99;

import java.util.Arrays;

public class ArrayScore {

    /**
     * 假设数组存储了 5 个评委对 1 个运动员的打分，且每个评委的打分都不相等。现在需要你：
     * 1、用数组按照连续顺序保存，去掉一个最高分和一个最低分后的 3 个打分样本；
     * 2、计算这 3 个样本的平均分并打印。
     * 要求是，不允许再开辟 O(n) 空间复杂度的复杂数据结构。
     * @param args
     */
    public static void main(String[] args) {
        int[] score = new int[]{90,60,70,80,50};
        // 最大值的下标以及数值
        int maxIdx = 0;
        int maxVal = score[0];
        // 最小值的下标以及数值
        int minIdx = 0;
        int minVal = score[0];
        for (int i=0; i<score.length; i++){
            int val = score[i];
            if(val < minVal){
                minVal = val;
                minIdx = i;
            }
            if(val > maxVal){
                maxVal = val;
                maxIdx = i;
            }
        }
        System.out.println("maxIdx="+maxIdx);
        System.out.println("maxVal="+maxVal);
        System.out.println("minIdx="+minIdx);
        System.out.println("minVal="+minVal);
        // 删除最大值、最小值
        int idx0 = minIdx;
        int idx1 = maxIdx;
        if(minIdx > maxIdx){
            idx0 = maxIdx;
            idx1 = minIdx;
        }
        for(int i=idx1; i<score.length; i++){
            if(i+1 >= score.length){
                score[i] = 0;
                break;
            }
            score[i] = score[i+1];
        }
        for (int i=idx0; i<score.length-1; i++){
            if(i+1 >= score.length){
                score[i] = 0;
                break;
            }
            score[i] = score[i+1];
        }
        Arrays.stream(score).forEach(System.out::println);
        // 求剩余分数的平均值
        int sum = 0;
        for (int i=0; i<score.length; i++){
            sum += score[i];
        }
        System.out.println("avg="+sum/(score.length-2));
    }
}
