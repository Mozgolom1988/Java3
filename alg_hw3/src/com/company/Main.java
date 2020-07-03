package com.company;

import javafx.beans.property.ObjectProperty;

import javax.sound.midi.Soundbank;

public class Main {

    public static void main(String[] args) {

        //Задание 1: Создать программу, которая переворачивает вводимые строки (читает справа налево);
        System.out.println("Проверка задание 1:");
        System.out.println(stringBackRead("!тевирП ,янА"));

        //Задание 2: Создать класс для реализации дека (в разработке)
        System.out.println("Проверка задание 2:");
        Dequeue deq = new Dequeue(20);
        deq.insertFirst(4);
        deq.insertFirst(3);
        deq.insertFirst(2);
        deq.insertLast(5);
        deq.insertFirst(1);
        deq.insertLast(6);
        for (int i = 0; i < 6; i++) {
            System.out.println(deq.removeLast());
        }


        //Задание 3: Реализовать класс с приоритетной очередью
        QueuePriority testP = new QueuePriority(20);
        testP.insert(5,1);
        testP.insert(6,1);
        testP.insert(7,1);
        testP.insert(4,2);
        testP.insert(7,1);
        testP.insert(7,1);
        testP.insert(7,5);

        System.out.println("Проверка задание 3:");
        for (int i = 1; i < 8; i++) {
            ObjectQueuePriority temp = testP.remove();
           System.out.println("Priority " + temp.getPriority() + " Value " + temp.getValue());
        }

    }

    public static String stringBackRead(String in) {
        String out = "";
        for (int i = in.length()-1; i >-1 ; i--) {
            out += in.charAt(i);
        }
        return out;

    }
}
