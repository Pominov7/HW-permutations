package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Permutations {
    /*
         Задача: написать процедуру, которая на вход получает массив
         и выводит все комбинации элементов данного массива
         ПРИМЕР РАБОТЫ:
         123 ->
         123
         132
         213
         231
         312
         321
         Число комбинаций массива из n элементов == n!          */
    //Решение:
    //Процедура вычисления факториала:
    public static int factorial(int n) {
            int res = 1;
            for (int i = 2; i <= n; i++)
                res *= i;
            return res;
        }

    public static void permutations(int[] arr) {
        permuteIteration(arr, 0);
    }
    //Процедура перестановки элементов массива:
    private static void permuteIteration(int[] arr, int index) {
        //последняя итерация
        if (index >= arr.length - 1) {//Терминальная ветвь
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = index; i < arr.length; i++) {

            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;

            permuteIteration(arr, index + 1);//Рекурсивный вызов

            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        //1.Ввод данных, объявление переменных
        Scanner in = new Scanner(System.in);
        System.out.print("Введите длину массива:");
        int n = in.nextInt();
        int[] arr = new int[n];
        //2.Заполнение массива
        for (int i = 0; i < arr.length; i++) {
            arr[i] += i + 1;
        }
        //3.Вывод в консоль
        permutations(arr);
        System.out.println("Количество перестановок = " + factorial(n));
    }
}

