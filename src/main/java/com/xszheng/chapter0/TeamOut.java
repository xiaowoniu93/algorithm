package com.xszheng.chapter0;

import java.util.LinkedList;
import java.util.List;

/**
 * 几个人围成一圈，从第n个人开始报数，报到m的人出列，从下一个人再重复报数，报到m的人出列，以此循环，直到所有人都出列。输出出列人的顺序
 * @author zhengxiaosun
 *
 */
public class TeamOut {
	
	public static void main(String[] args) {
		TeamOut teamOut = new TeamOut();
		int totalPerson = 10;
		boolean[] circle = teamOut.init(totalPerson);
		teamOut.gameStart(circle, 2, 3);
	}
	
	/**
	 * 开始游戏
	 * @param circle
	 * @param n 从第几个人开始报数
	 * @param m 数到几的人出列
	 */
	public void gameStart(boolean[] circle, int n, int m) {
		List<Integer> result = new LinkedList<>();
		int startIndex = n % circle.length - 1;
		// 累计报数到m
		int statistics = 0;
		// 出列人数
		int outCount = 0;
		while(true){
			if(outCount >= circle.length){
				// 所有人都出列了，表示游戏结束
				break;
			}
			boolean value = circle[startIndex];
			if(value){
				++statistics;
				if(statistics >= m){
					statistics = 0;
					// 出列的人置为false
					circle[startIndex] = false;
					++outCount;
					result.add(startIndex + 1);
				}
			}
			++startIndex;
			if(startIndex >= circle.length){
				startIndex = startIndex % circle.length;
			}
		}
		System.out.println(result);
	}
	
	/**
	 * 初始化数组
	 * @param totalPerson
	 * @return
	 */
	public boolean[] init(int totalPerson){
		boolean[] circle = new boolean[totalPerson];
		for(int i=0; i<totalPerson; i++){
			circle[i] = true;
		}
		return circle;
	}
}
