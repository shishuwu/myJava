package com.shishuwu.concurrent.wait_notify;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static final int MAX_NUM = 10;
    private List<String> dishes = new ArrayList<>(10);


    public void produceDish(String dish) {
        synchronized (dishes) {
            if (dishes.size() == MAX_NUM) {
                try {
                    dishes.wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }

            dishes.add(dish);
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
            if (dishes.isEmpty()) {
                try {
                    dishes.wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }

            dish = dishes.get(0);
            dishes.remove(0);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dishes.notifyAll();
        }
        return dish;
    }
}
