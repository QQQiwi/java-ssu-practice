import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class App {
    public static void main(String[] args) throws Exception {
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
        for (File curFile : dir.listFiles())
        {
            if (curFile.getName().toLowerCase().contains(keyString))
            {
                if (curFile.isFile())
                {
                    FileInputStream fis = new FileInputStream(curFile);
                    ZipEntry zipEntry = new ZipEntry(curFile.getName());
                    zipOut.putNextEntry(zipEntry);
            
                    byte[] bytes = new byte[1024];
                    int length;
                    while((length = fis.read(bytes)) >= 0) {
                        zipOut.write(bytes, 0, length);
                    }
                    fis.close();
                }
                else
                {
                    Files.walkFileTree(curFile.toPath(), new SimpleFileVisitor<Path>() {
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                            String newZipFileName = dir.toPath().relativize(file).toString();
                            zipOut.putNextEntry(new ZipEntry(newZipFileName));
                            Files.copy(file, zipOut);
                            zipOut.closeEntry();
                            return FileVisitResult.CONTINUE;
                        }

                        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                            zipOut.putNextEntry(new ZipEntry(curFile.toPath().relativize(dir).toString() + "/"));
                            zipOut.closeEntry();
                            return FileVisitResult.CONTINUE;
                        }
                    });
                }
            };
        }
        zipOut.close();
        fos.close();
    }
}
