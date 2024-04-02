import java.util.Scanner;

public class App {

    enum weekEnum
    {
        monday, tuesday, wednesday, thursday, friday, saturday, sunday
    };

    public static void main(String[] args) throws Exception {
        System.out.println("Введите день недели и количество дней:");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        String delims = "[ ]";
        String[] data = input.split(delims);

        System.out.println("Результат работы программы:");
        var daysAmount = Integer.valueOf(data[1]);
        var resultDayIdx = (daysAmount + weekEnum.valueOf(data[0]).ordinal())
                           % 7;
        System.out.println(weekEnum.values()[resultDayIdx]);
    }
}
