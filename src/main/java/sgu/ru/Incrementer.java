package main.java.sgu.ru;

public class Incrementer {
    private static int count = 0;
    private static final Object lock = new Object(); // создаем объект для блокировки (мьютекс)

    public static void main(String[] args) {
        Incrementer incrementer = new Incrementer();
        int incrementAmount = 100000;

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < incrementAmount; i++) {
                incrementer.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < incrementAmount; i++) {
                incrementer.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Результат инкрементирования: " + incrementer.getCount());
    }

    public void increment() {
        synchronized (lock) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
