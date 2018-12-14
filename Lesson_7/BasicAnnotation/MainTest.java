package Lesson_7.BasicAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void start(Class c) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = c.getDeclaredMethods();
        ArrayList <Method> listMethods = new ArrayList <Method>();

        for (Method o:methods) {
            if (o.isAnnotationPresent(Test.class)){
                listMethods.add(o);
            }
        }

        Method temporary;
        boolean toReturn=true;
        int count=0;
        while (toReturn){
            for(int j=0;j<listMethods.size()-1;j++){
                if (listMethods.get(j).getAnnotation(Test.class).priority()<listMethods.get(j+1).getAnnotation(Test.class).priority()){
                    temporary=listMethods.get(j);
                    listMethods.remove(j);
                    listMethods.add(temporary);
                    count++;
                }
            }
            if (count==0){
                toReturn=false;
            }
            count=0;
        }

        for (Method o:methods) {
            if (o.isAnnotationPresent(BeforeSuite.class)){
                if(listMethods.get(0).isAnnotationPresent(BeforeSuite.class)){
                    throw new RuntimeException("Методов BeforeSuite больше одного");
                }
                listMethods.add(0,o);
            }
            if (o.isAnnotationPresent(AfterSuite.class)){
                if(listMethods.get(listMethods.size()-1).isAnnotationPresent(AfterSuite.class)){
                    throw new RuntimeException("Методов AfterSuite больше одного");
                }
                listMethods.add(o);
            }
        }

        for (Method o: listMethods) {
            o.invoke(null);
        }
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        start(Tests.class);
    }
}
