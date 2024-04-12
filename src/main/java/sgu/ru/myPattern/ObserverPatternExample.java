package main.java.sgu.ru.myPattern;


public class ObserverPatternExample {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        ConcreteObserver observer1 = new ConcreteObserver("Наблюдатель 1");
        ConcreteObserver observer2 = new ConcreteObserver("Наблюдатель 2");

        subject.attach(observer1);
        subject.attach(observer2);

        subject.sendMessage("Важное сообщение!");

        subject.detach(observer2);

        subject.sendMessage("Еще одно сообщение!");
    }
}
