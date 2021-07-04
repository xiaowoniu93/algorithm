package com.xszheng.chapter99;

public class Train {

    // 火车A的速度
    private int speedA = 5;

    // 火车B的速度
    private int speedB = 10;

    // 扔球的次数
    private int count = 0;

    /**
     * 计算扔球的次数
     * @param distance
     * @return
     */
    private void calcCount(int distance) {
        while (distance > 0) {
            distance -= speedA;
            distance -= speedB;
            this.count++;
        }
    }

    public static void main(String[] args) {
        Train train = new Train();
        int distance = 10;
        train.calcCount(distance);
        System.out.println("总次数：" + train.count);
    }
}
