package com.shishuwu.concurrent.wait_notify;


public class Guest implements Runnable {
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
