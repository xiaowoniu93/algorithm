package com.xszheng.chapter0;

/**
 * 有n步台阶，一次只能走一步或两步，共有几种走法
 * @author xszheng
 * 分析
 * n											走法
 * 1		一步									f(1)=1
 * 2		①一步一步②直接两步					f(2)=2
 * 3		①先到f(1)再跨两步②先到f(2)再跨1步		f(3)=f(2)+f(1)
 * 4		①先到f(2)再跨两步②先到f(3)再跨1步		f(4)=f(2)+f(3)
 * n		①先到f(n-2)再跨两步②先到f(n-1)再跨1步	f(n)=f(n-2)+f(n-1)
 */
public class Step {
	
	public static void main(String[] args){
		System.out.println(f(40));
	}

	public static int f(int n){
		if(n < 1){
			throw new IllegalArgumentException(n+"不能小于1");
		}
		if(n == 1 || n == 2){
			return n;
		}
		return f(n-2)+f(n-1);
	}
}
