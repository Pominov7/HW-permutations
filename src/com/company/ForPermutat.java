package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class ForPermutat {
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

    //Процедура перестановки элементов массива:
    public static void permutations(int[] arr, int n) {
        int max = arr.length - 1;
        int count = max;
        for (; n > 0; ) {
            int temp = arr[count];
            arr[count] = arr[count - 1];
            arr[count - 1] = temp;
            System.out.println(Arrays.toString(arr));
            n--;
            if (count < 2) {
                count = max;
            } else {
                count--;
            }
        }
    }

    public static void main(String[] args) {
        //1.Ввод данных, объявление переменных
        Scanner in = new Scanner(System.in);
        System.out.print("Введите длину массива:");
        int n = in.nextInt();
        int[] arr = new int[n];
        int count = factorial(arr.length);
        //2.Заполнение массива
        for (int i = 0; i < arr.length; i++) {
            arr[i] += i + 1;
        }
        System.out.println("Количество перестановок = " + factorial(n));
        permutations(arr, count);
    }
}

