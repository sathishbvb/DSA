package com.sathish.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadExperiment {

    public static void main(String[] args) throws InterruptedException {
        try(ExecutorService executorService = Executors.newCachedThreadPool()){
            workProducer workProducer = new workProducer();
            for(int i=0;i<1;i++)
                executorService.execute(new workProducer());
            System.out.println( executorService.awaitTermination(1, TimeUnit.SECONDS));
        }
    }
}

class workProducer implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName());
    }
}

class Worker implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName());
    }
}
