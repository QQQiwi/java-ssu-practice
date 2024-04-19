package main.java.sgu.ru.FoodQueue;

import java.util.Queue;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        Queue<Food> queue = new LinkedList<>();
        int numConsumers = 5;

        for (int i = 1; i <= numConsumers; i++) {
            Thread consumerThread = new Thread(new Consumer(queue, "Потребитель " + i));
            consumerThread.start();
        }

        Thread producerThread = new Thread(new Producer(queue));
        producerThread.start();
    }
}

