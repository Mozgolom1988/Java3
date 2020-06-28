package com.company;

public class Main {

    public static void main(String[] args) {
        //1 Описать простейшие алгоритмы:
        //1.1 Возведение в степень (*используя чётность степени)
        DegreeNumber(2,3);
        //1.2 Поиск минимального элемента в массиве
        FindMinInArray(new int[]{2, 3, 5, -8});
        //1.3 Нахождение среднего арифметического массива
        MiddleSumArray(new int[]{2, 8, 4, 2});

        //2 Подсчитать сложность описанных алгоритмов:
        //Задание 1	O(n);
        //Задание 2 O(n);
        //Задание 3 O(n);

        //3 Какие правила подсчёта применялись, оставьте комментарии в коде:

    }

    public static void DegreeNumber(int a, int degree) {
        double result = Math.pow(a, degree);
        System.out.println("Число " + a + " в степени " + degree + " равно: "+  result);
    }

    public static void FindMinInArray(int[] NumberArray) {
        int result = NumberArray[0];
        for (int i = 1; i < NumberArray.length; i++) {
            if (result > NumberArray[i]) {
                result = NumberArray[i];
            }

        }
        System.out.println("Минимальное число в массиве: " + result);

    }

    public static void MiddleSumArray(int[] NumberArray) {
        int sumArray = 0;
        for (int i = 0; i < NumberArray.length; i++) sumArray += NumberArray[i];
        System.out.println("Среднеарифмитическое значение в массиве: " + (sumArray/NumberArray.length));
    }



}
