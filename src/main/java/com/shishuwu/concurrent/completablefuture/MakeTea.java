package com.shishuwu.concurrent.completablefuture;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

// task1: 洗水壶(1分钟) -> 烧开水(15分钟)
// task2: 洗茶壶(1分钟) -> 洗茶杯(2分钟) -> 拿茶叶 (1分钟)
//                  task3: (1 & 2) -> 泡茶
public class MakeTea {
    CompletableFuture<Void> task1 = CompletableFuture.runAsync(() -> {
        System.out.println(Thread.currentThread().getId());
        try {
            System.out.println("T1: 洗水壶...");
            TimeUnit.SECONDS.sleep(1);

            System.out.println("T1: 烧开水...");
            TimeUnit.SECONDS.sleep(15);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });


    CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
        System.out.println(Thread.currentThread().getId());
        try {
            System.out.println("T2: 洗茶壶...");
            TimeUnit.SECONDS.sleep(1);

            System.out.println("T2: 洗茶杯...");
            TimeUnit.SECONDS.sleep(2);

            System.out.println("T2: 拿茶叶...");
            TimeUnit.SECONDS.sleep(1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return " 龙井 ";
    });


    CompletableFuture<String> task3 = task1.thenCombine(task2, (__, tea) -> {
        System.out.println(Thread.currentThread().getId());
        System.out.println("T1: 拿到茶叶: " + tea);
        System.out.println("T1: 泡茶...");
        return " 上茶: " + tea;
    });


    public static void main(String[] args) {
        MakeTea makeTea = new MakeTea();
        makeTea.task3.join();
    }

}
