package com.shishuwu.concurrent.wait_notify.sample1;

import com.shishuwu.concurrent.wait_notify.sample1.Chef;
import com.shishuwu.concurrent.wait_notify.sample1.Guest;
import com.shishuwu.concurrent.wait_notify.sample1.Restaurant;
import org.junit.Test;

public class RestaurantTest {


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

    @Test
    public void testOneProducerAndMoreConsumer() throws InterruptedException {
        Restaurant restaurant = new Restaurant();

        Chef chef = new Chef(restaurant);
        Guest guest = new Guest(restaurant);
        Guest guest2 = new Guest(restaurant);

        chef.start();
        guest.start();
        guest2.start();

        chef.join();
        guest.join();
        guest2.join();

    }


    @Test
    public void testMoreProducerAndOneConsumer() throws InterruptedException {
        Restaurant restaurant = new Restaurant();

        Chef chef = new Chef(restaurant);
        Chef chef1 = new Chef(restaurant);
        Guest guest = new Guest(restaurant);

        chef.start();
        chef1.start();
        guest.start();

        chef.join();
        chef1.join();
        guest.join();
    }


    @Test
    public void testMoreProducerAndMoreConsumer() throws InterruptedException {
        Restaurant restaurant = new Restaurant();

        Chef chef = new Chef(restaurant);
        Chef chef1 = new Chef(restaurant);
        Guest guest = new Guest(restaurant);
        Guest guest1 = new Guest(restaurant);
        Guest guest2 = new Guest(restaurant);

        chef.start();
        chef1.start();
        guest.start();
        guest1.start();
        guest2.start();

        chef.join();
        chef1.join();
        guest.join();
        guest1.join();
        guest2.join();
    }
}

