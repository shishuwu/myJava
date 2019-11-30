package com.shishuwu.concurrent.wait_notify;

import java.util.Queue;

public class Chef implements Runnable {

    Restaurant restaurant;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            String dish = "dish " + i++;
            restaurant.produceDish(dish);
            System.out.println("chef produced: " + dish);
        }
    }
}
