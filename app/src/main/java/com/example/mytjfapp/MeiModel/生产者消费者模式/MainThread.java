package com.example.mytjfapp.MeiModel.生产者消费者模式;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2019-04-04 0004.
 */

public class MainThread {

    public static void main(String[] args) throws InterruptedException {
        Vector shareQueue = new Vector();


        int size = 4;


        ExecutorService service = Executors.newCachedThreadPool();

        Producer prodThread1 = new Producer(shareQueue, size);
        Producer prodThread2 = new Producer(shareQueue, size);
        Producer prodThread3 = new Producer(shareQueue, size);

        Consumer consThread1 = new Consumer(shareQueue, size);
        Consumer consThread2 = new Consumer(shareQueue, size);
        Consumer consThread3 = new Consumer(shareQueue, size);


        service.execute(prodThread1);
        service.execute(prodThread2);
        service.execute(prodThread3);
        service.execute(consThread1);
        service.execute(consThread2);
        service.execute(consThread3);


        Thread.sleep(10 * 1000);


        prodThread1.stop();

        prodThread2.stop();
        prodThread3.stop();

        Thread.sleep(3000);
        service.shutdown();

    }
}
