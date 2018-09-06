package com.xszheng.queue.domain;

import java.util.Comparator;

public class Human {

	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 存款
	 */
	private double money;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Human() {
		super();
	}

	public Human(String name, double money) {
		super();
		this.name = name;
		this.money = money;
	}

	@Override
	public String toString() {
		return name + " 存款为 [" + money + "]";
	}
	
	public static class HumanComparator implements Comparator<Human>{

		@Override
		public int compare(Human h1, Human h2) {
			return -Double.compare(h1.getMoney(), h2.getMoney());
		}
		
	}
}
