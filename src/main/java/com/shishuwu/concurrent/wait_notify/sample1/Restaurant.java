package com.shishuwu.concurrent.wait_notify.sample1;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static final int MAX_NUM = 100;
    private List<String> dishes = new ArrayList<>(10);


    public void produceDish(String dish) {
        synchronized (dishes) {
            while (dishes.size() == MAX_NUM) {
                try {
                    dishes.wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }

            dishes.add(dish);
            System.out.println("current capacity: " + dishes.size() +"/" + MAX_NUM);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dishes.notifyAll();
        }

    }

    public String consumeDish() {

        String dish = null;
        synchronized (dishes) {
            while (dishes.isEmpty()) {
                try {
                    dishes.wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }

            dish = dishes.get(0);
            dishes.remove(0);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dishes.notifyAll();
        }
        return dish;
    }
}
