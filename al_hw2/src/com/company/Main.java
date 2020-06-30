package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr; // int arr[]
        arr = new int[5];
        int[] arr2 = {1, 2, 3, 4};

        //массив на 25
        Array a0 = new Array(7, 6, 5, 4, 3,2,1,0,4,3,2,2,5,4,3,3,5,2,2,2,5,7,1,5,3);

        //массив на 60
        Array a1 = new Array(7, 6, 4, 3,2,1,0,4,3,2,2,5,4,3,3,5,2,2,2,5,7,1,5,3, 3,2,1,0,4,3,2,2,5,4,3,3, 3,2,1,0,4,3,2,2,5,4,3,3, 3,2,1,0,4,3,2,2,5,4,3,3);


        //массив на 180
        Array a2 = new Array(7, 6, 4, 3,2,1,0,4,3,2,2,5,4,3,3,5,2,2,2,5,7,1,5,3, 3,2,1,0,4,3,2,2,5,4,3,3, 3,2,1,0,4,3,2,2,5,4,3,3, 3,2,1,0,4,3,2,2,5,4,3,3,
                7, 6, 4, 3,2,1,0,4,3,2,2,5,4,3,3,5,2,2,2,5,7,1,5,3, 3,2,1,0,4,3,2,2,5,4,3,3, 3,2,1,0,4,3,2,2,5,4,3,3, 3,2,1,0,4,3,2,2,5,4,3,3,
                7, 6, 4, 3,2,1,0,4,3,2,2,5,4,3,3,5,2,2,2,5,7,1,5,3, 3,2,1,0,4,3,2,2,5,4,3,3, 3,2,1,0,4,3,2,2,5,4,3,3, 3,2,1,0,4,3,2,2,5,4,3,3);

        int o_n  = a0.sortBubble();
        int o_n1 = a1.sortBubble();
        int o_n2 = a2.sortBubble();


        System.out.println("Размер массива: "+ a0.length() +" операций сортировки: "+ o_n);
        System.out.println("Размер массива: "+ a1.length() +" операций сортировки: "+ o_n1);
        System.out.println("Размер массива: "+ a2.length() +" операций сортировки: "+ o_n2);

        //Итоги сортировок:
        //1. sortCount  O(n): 25м - 74, 60 - 179; 180 -539; ПОЛУЧАЕМ n*3;
        //2. sortInsert O(n^2): 25м - 184; 60 - 1106; 180 - 9753; получаем n*n/3;
        //3. sortSelect O(n): 25м-25; 60м-60; 180м-180; получаем n;
        //4. sortBubble O(n^2): 25м-300;60м-1770; 180м-16110; n*n/2;

    }
}