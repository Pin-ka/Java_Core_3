package Lesson_3.transferPlayer;

import java.io.Serializable;

public class Player implements Serializable {
    int power;
    int rank;
    String name;
    String species;

    public Player(int power, int rank, String name, String species) {
        this.power = power;
        this.rank = rank;
        this.name = name;
        this.species = species;
    }

    public void info(){
        System.out.println("Отчёт об игроке:\nИмя - "+name+"\nРод - "+species+"\nСила - "+power+"\nУровень - "+rank);
    }
}
