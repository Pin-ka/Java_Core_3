package Lesson_7.AutoFillTable;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        prepareTable(Students.class);
        Students stud1=new Students(187,"Ivan Ivanov",120,"email@mail.ru");
        putToTable(stud1,Students.class);
    }

    public static void putToTable(Students student, Class c) {
        HashMap<Class, String> hm = new HashMap<>();
        hm.put(int.class, "INTEGER");
        hm.put(String.class, "TEXT");
        try {
            connect();
            int id=student.id;
            String name=student.name;
            int score=student.score;
            String email=student.email;

            String tableName = ((Xtable)c.getAnnotation(Xtable.class)).name();

            String query = "INSERT INTO " + tableName + " (";
            Field[] fields = c.getDeclaredFields();

            for (Field o : fields) {
                if(o.isAnnotationPresent(Xfield.class)) {
                    query += o.getName() + ", ";
                }
            }
            query = query.substring(0, query.length()-2);
            query +=")";
            query+=" VALUES ('"+id+"', '"+name+"', '"+score+"', '"+email+"')";
            stmt.execute(query);

            disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static Connection connection;
    static Statement stmt;


    public static void connect() throws Exception {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() throws Exception {
        connection.close();
    }


    public static void prepareTable(Class c) {
        HashMap<Class, String> hm = new HashMap<>();

        hm.put(int.class, "INTEGER");
        hm.put(String.class, "TEXT");

        try {
            connect();

            String tableName = ((Xtable)c.getAnnotation(Xtable.class)).name();
            stmt.execute("DROP TABLE IF EXISTS " + tableName + ";");

            String query = "CREATE TABLE IF NOT EXISTS " + tableName + " (";
            Field[] fields = c.getDeclaredFields();

            for (Field o : fields) {
                if(o.isAnnotationPresent(Xfield.class)) {
                    query += o.getName() + " " + hm.get(o.getType()) + ", ";
                }
            }
            query = query.substring(0, query.length()-2);
            query +=")";
            stmt.execute(query);

            disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
