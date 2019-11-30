/*
 * @(#) RestaurantWaitNotifyTest 1.0 11/30/2019
 *
 * Copyright 2019 HP Inc. All rights reserved.
 * HP PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.shishuwu.concurrent.wait_notify;

import org.junit.Test;

/**
 * TODO
 *
 * @author Jason Shi on 11/30/2019 - 9:30 AM.
 * @since HPDM 5.1
 */
public class RestaurantTest {

    @Test
    public void testRestaurant() {
        final Restaurant restaurant = new Restaurant();

        final int num = 100;

        Runnable chefTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < num; i++) {
                    restaurant.produceDish("dish" + i);
                    System.out.println("chef cooked dish: " + i);
                }

            }
        };


        Runnable jasonTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < num; i++) {
                    String dish = restaurant.consumeDish();
                    System.out.println("i'm eating " + dish);
                }
            }
        };

        Thread chef = new Thread(chefTask);
        chef.start();
        Thread jason = new Thread(jasonTask);
        jason.start();


        try {
            chef.join();
            jason.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
