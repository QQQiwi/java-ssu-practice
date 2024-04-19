package main.java.sgu.ru.FoodQueue;

import java.util.Queue;

class Consumer implements Runnable {
    private Queue<Food> queue;
    private int totalCalories = 0;
    private String name;

    public Consumer(Queue<Food> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Food food = queue.poll();
                if (food != null) {
                    totalCalories += food.getCalories();
                    System.out.println(name 
                                       + " потребил: "
                                       + food.getName()
                                       + ", всего калорий: "
                                       + totalCalories);
                }
            }
        }
    }
}