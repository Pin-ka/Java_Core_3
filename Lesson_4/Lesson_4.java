package Lesson_4;

public class Lesson_4 {
    static volatile int count=1;
    static Object now=new Object();
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    try {
                        Thread.sleep(10);
                        synchronized (now){
                            while (((count+2)%3)!=0){
                                now.wait();
                            }
                            System.out.print("A");
                            count++;
                            now.notifyAll();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    try {
                        Thread.sleep(10);
                        synchronized (now){
                            while (((count+1)%3)!=0){
                                now.wait();
                            }
                            System.out.print("B");
                            count++;
                            now.notifyAll();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    try {
                        Thread.sleep(10);
                        synchronized (now){
                            while ((count%3)!=0){
                                now.wait();
                            }
                            System.out.print("C");
                            count++;
                            now.notifyAll();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
