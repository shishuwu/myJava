package com.shishuwu.concurrent.wait_notify.sample1;

public class Chef extends Thread {

    Restaurant restaurant;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            long currentId = Thread.currentThread().getId();
            String dish = "dish [" + currentId + "]" + i++;
            restaurant.produceDish(dish);
            System.out.println("chef[" + Thread.currentThread().getId() + "] produced: " + dish);
        }
    }
}
