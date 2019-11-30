/*
 * @(#) RestaurantWaitNotify 1.0 11/30/2019
 *
 * Copyright 2019 HP Inc. All rights reserved.
 * HP PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.shishuwu.concurrent.wait_notify;

import java.util.ArrayList;
import java.util.List;

/**
 * Wait notify mechanism to implement Producer & Consumer
 *
 * @author Jason Shi on 11/30/2019 - 9:21 AM.
 * @since HPDM 5.1
 */
public class Restaurant {
    private static final int MAX_NUM = 10;
    private List<String> dishes = new ArrayList<>(10);


    public synchronized void produceDish(String dish) {
        while (dishes.size() >= MAX_NUM) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            dishes.add(dish);
            notifyAll();
        }
    }

    public synchronized String consumeDish() {

        String dish = null;

        while (dishes.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        dish = dishes.get(0);
        dishes.remove(0);
        notifyAll();

        return dish;
    }
}
