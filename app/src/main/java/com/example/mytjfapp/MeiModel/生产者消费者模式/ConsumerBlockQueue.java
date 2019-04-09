package com.example.mytjfapp.MeiModel.生产者消费者模式;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Administrator on 2019-04-04 0004.
 */

public class ConsumerBlockQueue implements Runnable {


    private final LinkedBlockingDeque shareQueue;
    private final int Size;


    private static final int SLEEPTIME = 1000;

    public ConsumerBlockQueue(LinkedBlockingDeque shareQueue, int size) {
        this.shareQueue = shareQueue;
        Size = size;
    }

    @Override
    public void run() {
        int data;
        Random r = new Random();


        while (true) {
            System.out.println("start consumer id = " + Thread.currentThread().getId());

            try {
                Thread.sleep(r.nextInt(SLEEPTIME));

                if (shareQueue.isEmpty()) {

                    data = (int) shareQueue.take();
                    System.out.println("consumer " + Thread.currentThread().getId() + " consume data：" + data
                            + ", size：" + shareQueue.size());
                } else {
                    System.out.println("Queue is empty, consumer " + Thread.currentThread().getId()
                            + " is waiting, size：" + shareQueue.size());
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
