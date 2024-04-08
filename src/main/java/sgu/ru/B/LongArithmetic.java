package src.main.java.sgu.ru.B;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class LongArithmetic {
    enum OperationsEnum {
        ADD, SUB, MULT, DIV, REM, POW
    }

    public static void main(String[] args) throws Exception {
        OperationsEnum chosenOperation;
        BigDecimal a;
        BigDecimal b;
        String[] inputList;
        
        System.out.println("Write:");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String delims = "[ ]";
        inputList = input.split(delims);
        scan.close();

        a = new BigDecimal(inputList[0]);
        b = new BigDecimal(inputList[1]);

        try {
            chosenOperation = OperationsEnum.valueOf(inputList[2]);
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
                if (inputList[1].contains("-")) {
                    var positiveB = b.multiply(new BigDecimal(-1));
                    var denominator = a.pow(positiveB.intValue());
                    var ans = new BigDecimal("1").divide(denominator,
                                                         20,
                                                         RoundingMode.FLOOR);
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
