package main.java.sgu.ru;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FindElements {
    public static void main(String[] args) {
        FindElements program = new FindElements();
        program.start();
    }


    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        System.out.println("Введите " + size + " целочисленных значений для массива:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        int secondLargest = findSecondLargest(array);
        int thirdSmallest = findThirdSmallest(array);

        System.out.println("Второе наибольшее число: " + secondLargest);
        System.out.println("Третье наименьшее число: " + thirdSmallest);

        scanner.close();
    }


    public int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }


    public int findSecondLargest(int[] array) {
        return Arrays.stream(array)
                     .boxed()
                     .sorted((a, b) -> Integer.compare(b, a))
                     .distinct()
                     .skip(1)
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("Массив содержит менее двух элементов"));
    }


    public int findThirdSmallest(int[] array) {
        return Arrays.stream(array)
                     .boxed()
                     .sorted()
                     .distinct()
                     .skip(2)
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("Массив содержит менее трех элементов"));
    }
}
