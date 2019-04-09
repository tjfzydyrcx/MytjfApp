package com.example.mytjfapp.MeiModel.生产者消费者模式;

import android.widget.PopupWindow;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2019-04-04 0004.
 */

public class Consumer implements Runnable {


    private final Vector shareQueue;
    private final int Size;


    private static final int SLEEPTIME = 1000;

    public Consumer(Vector shareQueue, int size) {
        this.shareQueue = shareQueue;
        Size = size;
    }

    @Override
    public void run() {
        Random r=new Random();


        while (true){
            System.out.println("start consumer id = " + Thread.currentThread().getId());

            try {
                Thread.sleep(r.nextInt(SLEEPTIME));

                while (shareQueue.isEmpty()) {
                    synchronized (shareQueue){
                        System.out.println("Queue is empty, consumer " + Thread.currentThread().getId()
                                + " is waiting, size：" + shareQueue.size());
                        shareQueue.wait();
                    }
                }
             synchronized (shareQueue){
                 System.out.println("consumer consume data：" + shareQueue.remove(0) + ", size：" + shareQueue.size());
                 shareQueue.notifyAll();
             }

            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
