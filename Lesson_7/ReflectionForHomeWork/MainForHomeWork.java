package Lesson_7.ReflectionForHomeWork;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class MainForHomeWork {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class ch= URLClassLoader.newInstance(new URL[]{new File("C:/Users/SkyFox/IdeaProjects/Java3_Pro/src/main/java/Lesson_7/ReflectionForHomeWork/homeworks").toURL()}).loadClass("Lesson1exHomework");
        Constructor constructor = ch.getConstructor();
        Object forVerify = constructor.newInstance();

        Method task3 = ch.getDeclaredMethod("evaluate",int.class,int.class,int.class,double.class);
        double res3 = (double) task3.invoke(forVerify,5,1,8,4.0);
        if (res3==25.0){
            System.out.println("Задача 3 решена верно");
        } else {
            System.out.println("Ошибка в задаче 3");
        }

        Method task4 = ch.getDeclaredMethod("compare",int.class,int.class);
        boolean res4 = (boolean) task4.invoke(forVerify,5,1);
        if (res4==false){
            System.out.println("Задача 4 решена верно");
        } else {
            System.out.println("Ошибка в задаче 4");
        }

        Method task5 = ch.getDeclaredMethod("plusMinus",int.class);
        String res5 = (String) task5.invoke(forVerify,5);
        if (res5.equalsIgnoreCase("Число положительное")){
            System.out.println("Задача 5 решена верно");
        } else {
            System.out.println("Ошибка в задаче 5");
        }

        Method task6 = ch.getDeclaredMethod("minusTrue",int.class);
        boolean res6 = (boolean) task6.invoke(forVerify,-5);
        if (res6){
            System.out.println("Задача 6 решена верно");
        } else {
            System.out.println("Ошибка в задаче 6");
        }
    }
}
