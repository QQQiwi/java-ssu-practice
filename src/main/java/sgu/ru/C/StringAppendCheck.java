import java.nio.charset.Charset;
import java.util.Random;

public class StringAppendCheck {
    private int strLen = 10;
    private int callAmount = 100000;

    private void firstTry() {
        Random random = new Random();
        for (int i = 0; i < callAmount; i++) {
            byte[] array = new byte[strLen];
            random.nextBytes(array);
            String generatedString = new String(array, Charset.forName("ISO-8859-1"));
        }
    }

    private void secondTry() {
        String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789qwertyuiop[]asdfghjkl;'zxcvbnm,./";
        char[] ch = ALPHA_NUMERIC_STRING.toCharArray();
        Random random = new Random();
        for (int i = 0; i < callAmount; i++) {
            char[] chars = new char[strLen];
            for (int j = 0; j < strLen; j++) {
                chars[j] = ch[random.nextInt(ch.length)];
            }
        }
    }

    private String generateRandomString(Random random, int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }


    private void thirdTry() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < callAmount; i++) {
            String randomString = generateRandomString(random, strLen);
            stringBuilder.append(randomString);
        }
    }

    private void fourthTry() {
        Random random = new Random();
        String str = new String();

        for (int i = 0; i < callAmount; i++) {
            String randomString = generateRandomString(random, strLen);
            str += randomString;
        }
    }

    private void fifthTry() {
        Random random = new Random();
        StringBuffer str = new StringBuffer();

        for (int i = 0; i < callAmount; i++) {
            String randomString = generateRandomString(random, strLen);
            str.append(randomString);
        }
    }

    public static void main(String[] args) {
        StringAppendCheck app = new StringAppendCheck();

        long start = System.currentTimeMillis();
        app.firstTry();
        System.out.println("Способ 1 (byte): " + (System.currentTimeMillis() - start) + " мс");

        start = System.currentTimeMillis();
        app.secondTry();
        System.out.println("Способ 2 (char): " + (System.currentTimeMillis() - start) + " мс");

        start = System.currentTimeMillis();
        app.thirdTry();
        System.out.println("Способ 3 (StringBuilder): " + (System.currentTimeMillis() - start) + " мс");

        start = System.currentTimeMillis();
        app.fourthTry();
        System.out.println("Способ 4 (String): " + (System.currentTimeMillis() - start) + " мс");

        start = System.currentTimeMillis();
        app.fifthTry();
        System.out.println("Способ 5 (StringBuffer): " + (System.currentTimeMillis() - start) + " мс");
    }
}
