package com.company;

import javafx.beans.property.ObjectProperty;

import javax.sound.midi.Soundbank;

public class Main {

    public static void main(String[] args) {

        //Задание 1: Создать программу, которая переворачивает вводимые строки (читает справа налево);
        System.out.println(stringBackRead("!тевирП ,янА"));

        //Задание 2: Создать класс для реализации дека (в разработке)


        //Задание 3: Реализовать класс с приоритетной очередью
        QueuePriority testP = new QueuePriority(20);
        testP.insert(5,1);
        testP.insert(6,1);
        testP.insert(7,1);
        testP.insert(4,2);
        testP.insert(7,1);
        testP.insert(7,1);
        testP.insert(7,5);

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
