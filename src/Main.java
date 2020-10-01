import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    private static void copyFileUsingJava7Files(File source, File dest) throws IOException { // Class Files của nio package
        // copy(InputStream in, Path target, CopyOption... options)
        //Copies all bytes from an input stream to a file.
        //Enum StandardCopyOption
        // Enum Constant and Description
        //ATOMIC_MOVE : Move the file as an atomic file system operation.
        //COPY_ATTRIBUTES : Copy attributes to the new file.
        //REPLACE_EXISTING: Replace an existing file if it exists.
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

    }
    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try{
            inputStream = new FileInputStream(source);
            outputStream = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer))!=-1){
                outputStream.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            outputStream.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        System.out.printf("Enter source file:");
        String sourcePath = in.nextLine();
        System.out.printf("Enter destination file:");
        String destPath = in.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

//        Main.copyFileUsingJava7Files(sourceFile, destFile);
//        System.out.printf("Copy completed");

        Main.copyFileUsingStream(sourceFile,destFile);
        System.out.println("Copy completed");
    }
}
