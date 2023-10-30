package ru.geekbrains.exc.lesson1;

import java.util.Random;
import java.util.Scanner;

class Program {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();


    public static void main(String[] args) {
        System.out.printf("Размерность массива: %d\n", task1(new int[]{5, -5, 6}));

    }

    /**
     * Задача 1
     * ========
     * Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
     * Если длина массива меньше некоторого заданного минимума, метод возвращает
     * -1, в качестве кода ошибки, иначе - длину массива.
     */

    static int task1(int[] arr) {
        if (arr == null)
            return -2;
        if (arr.length == 0) {
            return -1;
        }
        return arr.length;
    }
}
