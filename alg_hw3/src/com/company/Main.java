package com.company;

import javax.sound.midi.Soundbank;

public class Main {

    public static void main(String[] args) {

        //Задание 1:
        //Создать программу, которая переворачивает вводимые строки (читает справа налево);
        System.out.println(stringBackRead("!тевирП ,янА"));

        //Задание 2: в разработке

        //Задание 3: в разработке

    }

    public static String stringBackRead(String in) {
        String out = "";
        for (int i = in.length()-1; i >-1 ; i--) {
            out += in.charAt(i);
        }
        return out;

    }
}
