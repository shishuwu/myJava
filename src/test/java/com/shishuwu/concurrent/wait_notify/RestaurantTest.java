package com.shishuwu.concurrent.wait_notify;

import org.junit.Test;

public class RestaurantTest {

    @Test
    public void testRestaurant() {
        final Restaurant restaurant = new Restaurant();

        final int num = 5;

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

    @Test
    public void testOneOne() throws InterruptedException {
        Restaurant restaurant = new Restaurant();
        Guest guest = new Guest(restaurant);
        Chef chef = new Chef(restaurant);

        Thread guestT = new Thread(guest);
        Thread chefT = new Thread(chef);


        guestT.start();
        chefT.start();

        guestT.join();
        chefT.join();
    }
}

