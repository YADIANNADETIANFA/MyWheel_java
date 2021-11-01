package com.example.springbootwheel.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduled {

    @Scheduled(cron = "0/5 * * * * *")
    public void doSomething() {
        System.out.println("every 5 seconds thread: " + Thread.currentThread().getName());
        System.out.println("task start.......");
    }

    @Scheduled(cron = "0/3 * * * * *")
    public void doSomething2() {
        System.out.println("every 3 seconds thread: " + Thread.currentThread().getName());
        System.out.println("task start.......");
    }

    @Scheduled(cron = "0/10 * * * * *")
    public void doSomething3() {
        System.out.println("every 10 seconds thread: " + Thread.currentThread().getName());
        System.out.println("task start.......");
    }

}

/*
* springBoot简单的定时任务：    https://www.jianshu.com/p/3b149146fa74
* 上述定时任务在多实例情况下，各个实例都会跑，可能引起并发问题或者锁竞争。
* 分布式定时任务需使用quartz：     https://www.cnblogs.com/wanghan1109/p/11195344.html
* */
