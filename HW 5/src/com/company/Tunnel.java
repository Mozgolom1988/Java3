package com.company;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore CheckcountCARS;   //Добавлено

    public Tunnel(int MAX_CARS) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.CheckcountCARS  = new Semaphore(MAX_CARS); //Добавлено
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                CheckcountCARS.acquire();   //Добавлено
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                CheckcountCARS.release();   //Добавлено
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
