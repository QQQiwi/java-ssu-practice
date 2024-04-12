package main.java.sgu.ru;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;


public class FilterIntegerStream {
    public static void main(String[] args) {
        FilterIntegerStream program = new FilterIntegerStream();
        program.start();
    }

    
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите целочисленные значения через пробел"
                           + "(для завершения ввода нажмите Enter):");
        List<Integer> inputList = readInput(scanner);

        System.out.println("Простые числа из введенных:");
        inputList.stream()
                 .filter(isPrime())
                 .forEach(System.out::println);

        scanner.close();
    }


    public List<Integer> readInput(Scanner scanner) {
        List<Integer> inputList = new ArrayList<>();
        String inputLine = scanner.nextLine();
        Scanner lineScanner = new Scanner(inputLine);
        while (lineScanner.hasNext()) {
            if (lineScanner.hasNextInt()) {
                inputList.add(lineScanner.nextInt());
            } else {
                lineScanner.next();
            }
        }
        lineScanner.close();
        return inputList;
    }


    public Predicate<Integer> isPrime() {
        return number -> {
            if (number <= 1) return false;
            if (number <= 3) return true;
            if (number % 2 == 0 || number % 3 == 0) return false;
            for (int i = 5; i * i <= number; i += 6) {
                if (number % i == 0 || number % (i + 2) == 0) return false;
            }
            return true;
        };
    }
}
