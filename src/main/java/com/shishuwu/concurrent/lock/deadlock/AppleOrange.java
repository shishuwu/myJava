package com.shishuwu.concurrent.lock.deadlock;

public class AppleOrange {

    public static void main(String[] args) {
        final Object apple = new Object();
        final Object orange = new Object();

        Thread ming = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Ming want apple");
                synchronized (apple) {
                    System.out.println("Ming got apple");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Ming want orange");
                    synchronized (orange) {
                        System.out.println("Ming got orange");
                    }
                }
            }
        });

        Thread hong = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hong want orange");
                synchronized (orange) {
                    System.out.println("Hong got orange");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Hong want apple");
                    synchronized (apple) {
                        System.out.println("Hong got apple");
                    }
                }
            }
        });


        ming.start();
        hong.start();

    }
}
