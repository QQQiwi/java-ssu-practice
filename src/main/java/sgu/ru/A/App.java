import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите путь к файлу:");
        Scanner scan = new Scanner(System.in);
        String filepath = scan.nextLine();
        scan.close();
        System.out.println("");
        System.out.println("Результат работы программы:");
        try
        {
            File myObj = new File(filepath);
            Scanner myReader = new Scanner(myObj);

            long minDate = -1;
            long maxDate = 0;
            long curDate = 0;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MM dd");

            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                try {
                    Date parsedDate = dateFormat.parse(data);
                    curDate = parsedDate.getTime();
                } catch (Exception e) {
                    System.out.println("Проверь формат даты.");
                    e.printStackTrace();
                }

                if (minDate == -1 || minDate > curDate)
                {
                    minDate = curDate;
                }
                if (maxDate < curDate)
                {
                    maxDate = curDate;
                }
            }
            myReader.close();
            long diff = TimeUnit.MILLISECONDS.toDays(maxDate - minDate) + 1;
            System.out.println(diff);
        } catch (FileNotFoundException e)
        {
            System.out.println("Возникла ошибка чтения файла или вычисления дат"
                               + ". Проверьте введенные значения");
            e.printStackTrace();
        }
    }
}
