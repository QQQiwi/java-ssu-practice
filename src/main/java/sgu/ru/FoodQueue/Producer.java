package main.java.sgu.ru.FoodQueue;

import java.util.Queue;

class Producer implements Runnable {
    private Queue<Food> queue;

    public Producer(Queue<Food> queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            Food food = createFood(i);
            synchronized (queue) {
                queue.add(food);
                queue.notifyAll();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Food createFood(int i) {
        return new Food("Продукт " + i, i * 100);
    }
}
