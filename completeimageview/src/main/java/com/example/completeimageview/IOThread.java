package com.example.completeimageview;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by qiaoyuang on 2017/4/26.
 * 耗时逻辑处理线程
 */

class IOThread {

    private static ExecutorService singleThread;

   /* static Executor getSingleThread() {
        if (singleThread == null) {
            singleThread = Executors.newSingleThreadExecutor();
        }
        return singleThread;
    }*/

    static ExecutorService getSingleThread() {
        if (singleThread == null) {

            singleThread = new ThreadPoolExecutor(1, 1,
                    0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>());

        }
        return singleThread;
    }
}