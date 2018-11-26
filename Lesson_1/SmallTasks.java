package Lesson_1;

import java.util.ArrayList;

class UnknownArr <T>{
   private T[] obj;

    public UnknownArr(T[] obj) {
        this.obj = obj;
    }

    public void rotateIndex(int x,int y){
        T buffer=obj[x];
        obj[x]=obj[y];
        obj[y]=buffer;
    }
    public void rotateValue (T elem1, T elem2){
        T buffer=elem1;
        int j=0;
        for(int i=0;i<obj.length;i++){
            if(obj[i]==elem1){
                buffer=obj[i];
                j=i;
                obj[i]=elem2;
                break;
            }
        }
        for(int i=0;i<obj.length;i++){
            if(obj[i]==elem2&j!=i){
                obj[i]=buffer;
                break;
            }
        }
    }
    public void info(){
        for (T o:obj) {
            System.out.print(o+" ");
        }
        System.out.println();
    }

    public ArrayList toArrayList(){
        ArrayList <T> al=new ArrayList<T>();
        for (T o:obj) {
           al.add(o);
        }
        return al;
    }
}

public class SmallTasks {
    public static void main(String[] args) {
        System.out.println("1. Поменять местами элементы массива:");
        System.out.println("1.1 Заменой по индексам:");
        Integer[] arrInt={1,2,3,4,5};
        UnknownArr<Integer> arr1= new UnknownArr<Integer>(arrInt);
        System.out.print("    исходный массив: ");
        arr1.info();
        arr1.rotateIndex(0,4);
        System.out.println("Меняем 1ый и 5ый элементы");
        System.out.print("    новый массив: ");
        arr1.info();
        System.out.println("1.2 Заменой по значениям:");
        String[]arrStr={"a","b","c","d","e"};
        UnknownArr <String>arr2=new UnknownArr<String>(arrStr);
        System.out.print("    исходный массив: ");
        arr2.info();
        System.out.println("Меняем a и d элементы");
        arr2.rotateValue("a","d");
        System.out.print("    новый массив: ");
        arr2.info();

        System.out.println("2. Преобразовать массив в ArrayList:");
        System.out.print("    исходный массив: ");
        arr2.info();
        ArrayList<String> al;
        al=arr2.toArrayList();
        System.out.print("    выводим как ArrayList: ");
        for (int i=0;i<al.size();i++){
            System.out.print(al.get(i)+" ");
        }
        System.out.println();
    }
}

