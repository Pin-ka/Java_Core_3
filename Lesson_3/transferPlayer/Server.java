package Lesson_3.transferPlayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        ServerSocket serv = null;
        Socket sock;
        Scanner console;
        try {
            serv = new ServerSocket(8189);
            System.out.println("Сервер запущен, ожидаем подключения...");
            sock = serv.accept();
            System.out.println("Клиент подключился");
            console=new Scanner(System.in);

            ObjectInputStream ois=new ObjectInputStream(new FileInputStream("src/main/java/Lesson_3/human.pl"));
            Player humanInServ=(Player)ois.readObject();
            ois.close();
            humanInServ.info();
            while (true) {
                String strS = console.nextLine();
                if (strS.equals("end")) break;
            }

        } catch (IOException e) {
            System.out.println("Ошибка инициализации сервера");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                serv.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
