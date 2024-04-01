import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    static String process_string(String data)
    {
        var info_array = data.split("[ ]");
        if (info_array.length < 3)
        {
            return "Данные не полные!";
        }
        String second_name = info_array[0];
        String first_name = info_array[1];
        String last_name = info_array[2];
        String info_list = first_name + " " + second_name.charAt(0) + ". " + last_name.charAt(0) + ".";
        return info_list;
    }

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
            // File myObj = new File("test/input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              System.out.println(process_string(data));
            }
            myReader.close();
        } catch (FileNotFoundException e)
        {
            System.out.println("Файл не найден! Проверьте указанный путь.");
            e.printStackTrace();
        }
    }
}
