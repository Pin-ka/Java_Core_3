package Lesson_1;

import java.util.ArrayList;

public class FruitLogistics {
    public static void main(String[] args) {
        Box<Orange>boxOrange1=new Box<Orange>();
        Orange orange=new Orange();
        for (int i=1;i<=5;i++) {
            boxOrange1.addToBox(orange);
        }
        System.out.println("Вес 1ой коробки с апельсинами: "+boxOrange1.getWeight());
        Box<Orange>boxOrange2=new Box<Orange>();
        for (int i=1;i<=12;i++) {
            boxOrange2.addToBox(orange);
        }
        System.out.println("Вес 2ой коробки с апельсинами: "+boxOrange2.getWeight());
        Box <Apple>boxApple=new Box<Apple>();
        Apple apple=new Apple();
        for (int i=1;i<=18;i++) {
            boxApple.addToBox(apple);
        }
        System.out.println("Вес коробки с яблоками: "+boxApple.getWeight());
        if (!boxOrange1.compare(boxOrange2)) System.out.println("Коробки с апельсинами не равны по весу");
        if (boxOrange2.compare(boxApple)) System.out.println("Вес 2ой коробки с апельсинами равен весу коробки с яблоками");

        System.out.println("Пересыпем апельсины из 1ой коробки во 2ую:");
        boxOrange1.intersperse(boxOrange2);
        System.out.println("Вес 1ой коробки с апельсинами: "+boxOrange1.getWeight());
        System.out.println("Вес 2ой коробки с апельсинами: "+boxOrange2.getWeight());
    }
}

abstract class Fruit{
 abstract float getWeight();
}

class Apple extends Fruit {
    @Override
    float getWeight() {
        return 1.0f;
    }
}

class Orange extends Fruit{
    @Override
    float getWeight() {
        return 1.5f;
    }
}

class Box<T extends Fruit>{
    ArrayList<T> box=new ArrayList<T>();
    public Box(){}

    public void addToBox(T fruit){
        box.add(fruit);
    }
    public float getWeight(){
        float weight;
        int valueInBox=0;
        float weightOne=0.0f;
        if(box.size()!=0){
            valueInBox=box.size();
            weightOne=box.get(0).getWeight();
        }
        weight=valueInBox*weightOne;
        return weight;
    }
    public boolean compare(Box anotherBox) {
        if(getWeight() == anotherBox.getWeight()) return true;
        return false;
    }
    public void intersperse (Box <T> toBox){
        toBox.box.addAll(box);
        box.clear();
    }

}
