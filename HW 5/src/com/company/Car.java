package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier cb;           //Добавлено
    private CountDownLatch beginCD;     //Добавлено
    private CountDownLatch endCD;       //Добавлено

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier cb, CountDownLatch beginCD, CountDownLatch endCD) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cb = cb;                   //Добавлено
        this.beginCD = beginCD;         //Добавлено
        this.endCD   = endCD;           //Добавлено
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            beginCD.countDown();    //Добавлено
            cb.await();             //Добавлено

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
            if(!race.haveWinner.getAndSet(true)){   //Добавлено
                System.out.println(name + " - WIN");          //Добавлено
            }                                                 //Добавлено
            endCD.countDown();                                //Добавлено
    }
}
