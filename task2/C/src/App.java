import java.nio.charset.Charset;
import java.util.Random;
// import java.lang.Str;

public class App {
    static int strLen = 10;
    static int callAmount = 100000;

    static void firstTry()
    {
        Random random = new Random();
        for (int i = 0; i < callAmount; i++)
        {
            byte[] array = new byte[strLen];
            random.nextBytes(array);
            String generatedString = new String(array, Charset.forName("ISO-8859-1"));
        }
    }

    static void secondTry()
    {
        String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789qwertyuiop[]asdfghjkl;'zxcvbnm,./";
        char[] ch = ALPHA_NUMERIC_STRING.toCharArray();
        Random random = new Random();
        for (int i = 0; i < callAmount; i++)
        {
            char[] chars = new char[strLen];
            for (int j = 0; j < strLen; j++) {
                chars[j] = ch[random.nextInt(ch.length)];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Результат работы программы:");
        secondTry();
    }
}
