import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class App {
    static String[] parse_input() {
        System.out.println("Write:");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String delims = "[ ]";
        String[] strarray = input.split(delims);
        scan.close();
        return strarray;
    }

    enum OperationsEnum {
        ADD, SUB, MULT, DIV, REM, POW
    }

    public static void main(String[] args) throws Exception {
        String[] input_list;
        OperationsEnum chosenOperation;
        BigDecimal a;
        BigDecimal b;
        try {
            input_list = parse_input();
            a = new BigDecimal(input_list[0]);
            b = new BigDecimal(input_list[1]);
        } catch (Exception e) {
            System.out.println("Необходимо ввести значения" +
                               " в формате '<число> <число> <операция>'!");
            return;
        }

        try {
            chosenOperation = OperationsEnum.valueOf(input_list[2]);
        } catch (Exception e) {
            System.out.println("Некорректная операция!");
            return;
        }

        switch (chosenOperation) {
            case ADD:
                System.out.println(a.add(b));
                break;
            case SUB:
                System.out.println(a.subtract(b));
                break;
            case MULT:
                System.out.println(a.multiply(b));
                break;
            case DIV:
                System.out.println(a.divide(b, 20, RoundingMode.FLOOR));
                break;
            case REM:
                System.out.println(a.remainder(b));
                break;
            case POW:
                if (input_list[1].contains("-")) {
                    var positive_b = b.multiply(new BigDecimal(-1));
                    var denominator = a.pow(positive_b.intValue());
                    var ans = new BigDecimal("1").divide(denominator, 20, RoundingMode.FLOOR);
                    System.out.println(ans);
                }
                else
                {
                    System.out.println(a.pow(b.intValue()));
                }
                break;
            default:
                break;
        }
    }
}
