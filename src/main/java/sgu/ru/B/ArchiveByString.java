import java.io.*;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ArchiveByString {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        String delims = "[ ]";
        String[] splitedInput = input.split(delims);

        String directory = splitedInput[0];
        String keyString = splitedInput[1];

        File dir = new File(directory);
        FileOutputStream fos = new FileOutputStream(directory + ".zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);

        ArchiveByString archiver = new ArchiveByString();
        archiver.addToZip(dir, zipOut, keyString, "");

        zipOut.close();
        fos.close();
    }

    private void addToZip(File directory, ZipOutputStream zipOut, String keyString, String outPath) throws IOException {
        for (File curFile : directory.listFiles()) {
            if (curFile.getName().toLowerCase().contains(keyString) || outPath.contains(keyString)) {
                if (curFile.isFile()) {
                    FileInputStream fis = new FileInputStream(curFile);
                    ZipEntry zipEntry = new ZipEntry(outPath + curFile.getName());
                    zipOut.putNextEntry(zipEntry);

                    byte[] bytes = new byte[1024];
                    int length;
                    while ((length = fis.read(bytes)) >= 0) {
                        zipOut.write(bytes, 0, length);
                    }
                    fis.close();
                } else {
                    addToZip(curFile, zipOut, keyString, outPath + "/" + curFile.getName() + "/");
                }
            }
        }
    }
}
