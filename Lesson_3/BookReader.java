package Lesson_3;

import java.io.*;
import java.util.Scanner;

public class BookReader {
    public static void main(String[] args) {
        Scanner scanner=new Scanner (System.in);
        while (true) {
            System.out.println("Введите номер страницы или 0 для выхода:");
            int page = scanner.nextInt();
            if(page==0) break;
            readPage(page);
        }

    }

    private static void readPage(int n) {
        long t = System.currentTimeMillis();
        try(RandomAccessFile raf = new RandomAccessFile("src/main/java/Lesson_3/book.txt", "r")) {
            if((n<=0)||(n*1800>raf.length())){
                System.out.println("Такой страницы не существует");
                return;
            }

            for (int i=n*1800-1800;i<n*1800;i++) {
                raf.seek(i);
                System.out.print((char) raf.read());
            }
         System.out.println("\nВремя чтения: "+(System.currentTimeMillis() - t));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
