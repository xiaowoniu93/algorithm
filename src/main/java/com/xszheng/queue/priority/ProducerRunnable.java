package com.xszheng.queue.priority;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

import com.xszheng.queue.domain.Human;

public class ProducerRunnable implements Runnable {
	private static final String name = "明刚红李刘吕赵黄王孙朱曾游丽吴昊周郑秦丘";
	private Random random = new Random();
	private PriorityBlockingQueue<Human> queue;
	
	public ProducerRunnable(PriorityBlockingQueue<Human> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < name.length(); i++) {
			Human human = new Human("小"+name.charAt(i), random.nextInt(10000));
			// offer 方法不支持元素为null。元素要么实现 Comparable 接口，要么实例化 PriorityBlockingQueue 时，指定比较器
			queue.offer(human);
			System.out.println(human+" 开始排队...");
		}
	}

}
