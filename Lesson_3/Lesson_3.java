package Lesson_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class Lesson_3 {
    public static void main(String[] args) throws IOException {
        //Закомментировать после создания папки с файлами
        createFolder();

        //1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
        System.out.println("1. Прочитать файл в байтовый массив и вывести этот массив в консоль:");
        try {
            FileInputStream in=new FileInputStream("src/main/java/Lesson_3/files/file1.txt");
            byte[] arr=new byte[5];
            int x;
            while ((x=in.read(arr))>0){
                System.out.print(new String(arr, 0, x, "UTF-8"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("");
        //2. Последовательно сшить 5 файлов в один
        System.out.println("2. Последовательно сшить 5 файлов в один:");
        ArrayList<InputStream> ali = new ArrayList<>();
        try {
            ali.add(new FileInputStream("src/main/java/Lesson_3/files/file1.txt"));
            ali.add(new FileInputStream("src/main/java/Lesson_3/files/file2.txt"));
            ali.add(new FileInputStream("src/main/java/Lesson_3/files/file3.txt"));
            ali.add(new FileInputStream("src/main/java/Lesson_3/files/file4.txt"));
            ali.add(new FileInputStream("src/main/java/Lesson_3/files/file5.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Enumeration<InputStream> e = Collections.enumeration(ali);
        SequenceInputStream in=new SequenceInputStream(e);
        byte[] arr=new byte[1];
        int x;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        while ((x=in.read(arr))>0){
            //System.out.print(new String(arr, 0, x, "UTF-8"));
            out.write(arr);
        }
        byte[] arrW = out.toByteArray();
        in.close();
        FileOutputStream song=new FileOutputStream("src/main/java/Lesson_3/files/song.txt");
        song.write(arrW);
        song.close();

        try {
            FileInputStream in2=new FileInputStream("src/main/java/Lesson_3/files/song.txt");
            byte[] arr2=new byte[50];
            int x2;
            while ((x2=in2.read(arr2))>0){
                System.out.print(new String(arr2, 0, x2, "UTF-8"));
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private static void createFolder() {
        File folder=new File ("src/main/java/Lesson_3/files");
        folder.mkdirs();

        String lineSeparator=System.getProperty("line.separator");

        File file1=new File("src/main/java/Lesson_3/files/file1.txt");
        try {
            BufferedWriter writer=new BufferedWriter(new FileWriter(file1,true));
            writer.write("We all came out to Montreaux"+lineSeparator+"On the Lake Geneva shoreline\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file2=new File("src/main/java/Lesson_3/files/file2.txt");
        try {
            BufferedWriter writer=new BufferedWriter(new FileWriter(file2,true));
            writer.write("To make records with a Mobile"+lineSeparator+"We didn't have much time\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file3=new File("src/main/java/Lesson_3/files/file3.txt");
        try {
            BufferedWriter writer=new BufferedWriter(new FileWriter(file3,true));
            writer.write("Frank Zappa and the Mothers"+lineSeparator+"Were at the best place around\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file4=new File("src/main/java/Lesson_3/files/file4.txt");
        try {
            BufferedWriter writer=new BufferedWriter(new FileWriter(file4,true));
            writer.write("But some stupid with a flare gun"+lineSeparator+"Burned the place to the ground\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file5=new File("src/main/java/Lesson_3/files/file5.txt");
        try {
            BufferedWriter writer=new BufferedWriter(new FileWriter(file5,true));
            writer.write("Smoke on the water"+lineSeparator+"And fire in the sky");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
