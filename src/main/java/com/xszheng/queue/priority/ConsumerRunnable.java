package com.xszheng.queue.priority;

import java.util.concurrent.PriorityBlockingQueue;

import com.xszheng.queue.domain.Human;

public class ConsumerRunnable implements Runnable {

	private PriorityBlockingQueue<Human> queue;
	
	public ConsumerRunnable(PriorityBlockingQueue<Human> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			Human human = queue.poll();
			if(human == null){
				break;
			}
			System.out.println(human+" 办理业务");
		}
	}

}
