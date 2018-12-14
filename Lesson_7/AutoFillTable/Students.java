package Lesson_7.AutoFillTable;

@Xtable(name = "students")
public class Students {

    @Xfield
    int id;

    @Xfield
    String name;

    @Xfield
    int score;

    @Xfield
    String email;

    public Students(int id, String name, int score, String email) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.email = email;
    }

}
