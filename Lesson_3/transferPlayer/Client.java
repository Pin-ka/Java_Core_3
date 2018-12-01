package Lesson_3.transferPlayer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) {
        final String SERVER_ADDR = "localhost";
        final int SERVER_PORT = 8189;
        Socket sock;
        Scanner console;

        try {
            sock = new Socket(SERVER_ADDR, SERVER_PORT);
            console=new Scanner(System.in);
            Player human=new Player(50,1,"Crow","Harpies");
            human.info();
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("src/main/java/Lesson_3/human.pl"));
            oos.writeObject(human);
            oos.close();
            while (true) {
                String strS = console.nextLine();
                if (strS.equals("end")) break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
