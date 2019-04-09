package com.example.mytjfapp.MeiModel.生产者消费者模式;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://www.jianshu.com/p/3f0cd7af370d
 *
 *
 * Created by Administrator on 2019-04-04 0004.
 * 生产者-消费者问题
 *
 *
 * 生产者
 */

public class Producer implements Runnable {
    private volatile boolean isRunning = true;

    private final Vector shareQueue;
    private final int Size;

    private static AtomicInteger count = new AtomicInteger();

    private static final int SLEEPTIME = 1000;


    public Producer(Vector shareQueue, int size) {
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
                while (shareQueue.size() == Size) {
                    System.out.println("Queue is full, producer " + Thread.currentThread().getId()
                            + " is waiting, size：" + shareQueue.size());
                    shareQueue.wait();
                }

                synchronized (shareQueue) {

                    data = count.incrementAndGet();
                    shareQueue.add(data);
                    System.out.println("producer create data:" + data + ", size：" + shareQueue.size());

                    shareQueue.notifyAll();
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
