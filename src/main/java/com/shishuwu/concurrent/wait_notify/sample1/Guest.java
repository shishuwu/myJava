package com.shishuwu.concurrent.wait_notify.sample1;


public class Guest extends Thread {
    private Restaurant res;

    public Guest(Restaurant res) {
        this.res = res;
    }

    @Override
    public void run() {
        while(true){
            String dish = res.consumeDish();
            System.out.println("Guest consumed: " + dish);
        }
    }
}
