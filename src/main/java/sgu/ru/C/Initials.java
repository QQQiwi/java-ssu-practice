package src.main.java.sgu.ru.C;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Initials {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите путь к файлу:");
        Scanner scan = new Scanner(System.in);
        String filepath = scan.nextLine();
        scan.close();
        System.out.println("");
        System.out.println("Результат работы программы:");
        System.out.println("");
        try
        {
            File myObj = new File(filepath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                var infoArray = data.split("[ ]");
                if (infoArray.length < 3)
                {
                    System.out.println("Данные не полные!");
                    continue;
                }
                String secondName = infoArray[0];
                String firstName = infoArray[1];
                String lastName = infoArray[2];
                String infoList = firstName + " " + secondName.charAt(0) + ". "
                                  + lastName.charAt(0) + ".";
                System.out.println(infoList);
            }
            myReader.close();
        } catch (FileNotFoundException e)
        {
            System.out.println("Файл не найден! Проверьте указанный путь.");
            e.printStackTrace();
        }
    }
}
