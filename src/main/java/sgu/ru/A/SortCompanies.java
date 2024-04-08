import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

class RatingComparator implements Comparator<ArrayList<String>> {
    public int compare(ArrayList<String> c1, ArrayList<String> c2) {
        if (Integer.valueOf(c1.get(4)) <= Integer.valueOf(c2.get(4))) {
            return 1;
        } else {
            return -1;
        }
    }
}

class SecondNameComparator implements Comparator<ArrayList<String>> {
    public int compare(ArrayList<String> c1, ArrayList<String> c2) {
        return c1.get(0).compareTo(c2.get(0));
    }
}

class FirstNameComparator implements Comparator<ArrayList<String>> {
    public int compare(ArrayList<String> c1, ArrayList<String> c2) {
        return c1.get(1).compareTo(c2.get(1));
    }
}

class LastNameComparator implements Comparator<ArrayList<String>> {
    public int compare(ArrayList<String> c1, ArrayList<String> c2) {
        return c1.get(2).compareTo(c2.get(2));
    }
}

public class SortCompanies {

    public <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
        ArrayList<T> newList = new ArrayList<T>();
        for (T element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Введите путь к файлу:");
        Scanner scan = new Scanner(System.in);
        String filepath = scan.nextLine();
        scan.close();
        System.out.println("");
        System.out.println("Результат работы программы:");
        try {
            File myObj = new File(filepath);
            Scanner myReader = new Scanner(myObj);
            List<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
            while (myReader.hasNextLine()) {
                String curData = myReader.nextLine();
                var infoArray = curData.split("[ ]");
                data.add(new ArrayList<String>(Arrays.asList(infoArray)));
            }
            List<ArrayList<String>> uniqueData = new ArrayList<>(new HashSet<>(data));
            Collections.sort(uniqueData, new LastNameComparator());
            Collections.sort(uniqueData, new FirstNameComparator());
            Collections.sort(uniqueData, new SecondNameComparator());
            Collections.sort(uniqueData, new RatingComparator());
            System.out.println(uniqueData);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
            e.printStackTrace();
        }
    }
}
