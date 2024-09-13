//HELLO HI DYLAN TSAI ITS ME JACOB YOUR FRIEND JACOB MASSEY YOUR CLASSMATE NAMED JACOB WHO IS IN YOUR COMP SCI CLASS AGAIN HI HOW ARE YOU IS ALL I WANT TO KNOW THATS ALL I WANT TO KNOW JUST TELL ME HOW YOU ARE OK BYE THANKS SEE YOU LATER DYLAN TSAI MY CLASSMATE
import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class MyFileWriter {
    public static void main(String[] args) {
        String data = "x1234x!";
        String data2 = "o.o";
        String fileName1 = ".hiddenpassword.txt";
        String fileName0 = "moresecrets.txt";
        // String fileName2 = "example2.txt";
        // String fileName3 = "example3.txt";
        // String fileName4 = "example4.txt";
        // String fileName5 = "example5.txt";

        // 1. Using FileWriter
        // try (FileWriter writer = new FileWriter(fileName1)) {
        //     writer.write(data);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // 2. Using BufferedWriter
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName1))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // // 3. Using FileOutputStream
        // try (FileOutputStream outputStream = new FileOutputStream(fileName3)) {
        //     outputStream.write(data.getBytes());
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // // 4. Using BufferedOutputStream
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName1))) {
            bufferedOutputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(".secretdata/secretfile.txt"))) {
            bufferedWriter.write(data2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("secretfile.txt"))) {
        //     bufferedOutputStream.write(data2.getBytes());
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // // 5. Using Files (java.nio.file)
        // try {
        //     Files.write(Paths.get(fileName5), data.getBytes(StandardCharsets.UTF_8));
        // } catch (IOException e) {
        //     e.printStackTrace();
        printTotalFileSize(".hiddenpassword.txt", "moresecrets.txt", ".secretdata/secretfile.txt");
    }
    private static void printFileSize(String fileName) {
        try {
            System.out.println(Files.size(Paths.get(fileName)));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void printTotalFileSize(String... fileNames) {
        long totalSize = 0;
        for (String fileName : fileNames) {
            File file = new File(fileName);
            if (file.exists()) {
                totalSize += file.length();
            }
        }
        System.out.println("Total size of all files: " + totalSize + " bytes");
    }
    

}
