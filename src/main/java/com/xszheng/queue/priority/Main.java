package com.xszheng.queue.priority;

import java.util.concurrent.PriorityBlockingQueue;

import com.xszheng.queue.domain.Human;
import com.xszheng.queue.domain.Human.HumanComparator;

public class Main {

	public static void main(String[] args) throws Exception {
		PriorityBlockingQueue<Human> queue = new PriorityBlockingQueue<>(200, new HumanComparator());
		ProducerRunnable producer = new ProducerRunnable(queue);
		ConsumerRunnable consumer = new ConsumerRunnable(queue);
		Thread pro = new Thread(producer);
		Thread con = new Thread(consumer);
		pro.start();
		pro.join();
		con.start();
	}

}
