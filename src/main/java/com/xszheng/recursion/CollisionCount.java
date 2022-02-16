package com.xszheng.recursion;

/**
 * 有两辆小火车X 和Y，两车头相距M，两火车相向行驶，X 的速度为Vx，Y 的速度为Vy。
 * 从火车X 车头向Y 抛出一个小球B，假定小球的速度恒定为Vb。小球B 碰到火车Y 车头时返回，
 * 以速度Vb 向火车X 飞行，接触到火车X 车头时再次反向飞行，如此反复。
 * 请问：直到两火车车头相遇，小球这饭了几次？
 */
public class CollisionCount {

    /**
     * 此方法为初版
     */
    private int Vx = 1;
    private int Vy = 2;
    private int Vb = 3;
    private int m = 10;

    private int count = 0;

    // 计算次数
    public int calculateCount() {
        if (m <= 0) {
            return count;
        }
        if (count % 2 == 0) {
            m = m - (Vx + Vy) * calculateTime(true);
        } else {
            m = m - (Vx + Vy) * calculateTime(false);
        }
        count++;
        return calculateCount();
    }

    /**
     * 可能返回0 且 m > 0 导致栈溢出
     * @param direct
     * @return
     */
    public int calculateTime(boolean direct) {
        return (int) (m / (direct ? Vy + Vb : Vx + Vb));
    }

    public static void main(String[] args) {
        CollisionCount constant = new CollisionCount();
        System.out.println(constant.calculateCount());
    }
}
