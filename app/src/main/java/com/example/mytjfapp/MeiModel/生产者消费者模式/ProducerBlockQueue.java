package com.example.mytjfapp.MeiModel.生产者消费者模式;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://www.jianshu.com/p/3f0cd7af370d
 * <p>
 * <p>
 * Created by Administrator on 2019-04-04 0004.
 * 生产者-消费者问题
 * <p>
 * <p>
 * 生产者
 */

public class ProducerBlockQueue implements Runnable {
    private volatile boolean isRunning = true;

    private final LinkedBlockingDeque shareQueue;
    private final int Size;

    private static AtomicInteger count = new AtomicInteger();

    private static final int SLEEPTIME = 1000;


    public ProducerBlockQueue(LinkedBlockingDeque shareQueue, int size) {
        this.shareQueue = shareQueue;
        this.Size = size;
    }

    @Override
    public void run() {
        int data;
        Random r = new Random();


        while (isRunning) {

            System.out.println("start producer id = " + Thread.currentThread().getId());

            try {
                Thread.sleep(r.nextInt(SLEEPTIME));

                data = count.incrementAndGet();

                System.out.println("producer " + Thread.currentThread().getId() + " create data：" + data
                        + ", size：" + shareQueue.size());
                if (!shareQueue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.err.println("failed to put data：" + data);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();

                Thread.currentThread().isInterrupted();
            }
        }
    }

    public void stop() {
        isRunning = false;

    }


}
