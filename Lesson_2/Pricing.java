package Lesson_2;

import java.sql.*;
import java.util.Scanner;

public class Pricing {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement prstmt;
    private static ResultSet rs;
    private static Scanner scanner=new Scanner (System.in);

    public static void main(String[] args) {

        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            //Создание новой таблицы, если её не было
            createTableProduct();
            //Очистка таблицы
            stmt.executeUpdate("DELETE FROM products");
            //Автозаполнение
            connection.setAutoCommit(false);
            prstmt=connection.prepareStatement("INSERT INTO products (prodid,title,cost)\n" +
                    "VALUES(?,?,?)");
            for (int i=1;i<=10000;i++){
                prstmt.setInt(1,i);
                prstmt.setString(2,"товар"+i);
                prstmt.setInt(3,i*10);
                prstmt.addBatch();
            }
            prstmt.executeBatch();
            connection.setAutoCommit(true);

            System.out.println("Введите комманду или end, чтобы выйти");
            while (true) {
                String comma = scanner.nextLine();
                if (comma.startsWith("цена")) { //Вызов метода запроса цены
                    String[] arrComma = comma.split(" ");
                    printPrice(arrComma[1]);
                }
                if (comma.startsWith("сменитьцену")) { //Вызов метода изменения цены
                    String[] arrComma = comma.split(" ");
                    changePrice(arrComma[1], arrComma[2]);
                }
                if (comma.startsWith("товарыпоцене")) { //Вызов метода запроса товаров в ценовом диапазоне
                    String[] arrComma = comma.split(" ");
                    printPriceInRange(arrComma[1], arrComma[2]);
                }
                if(comma.equals("end")) break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
            disconnect();

        }

    }

    private static void printPriceInRange(String minPrice, String maxPrice) throws SQLException {
        stmt.execute("CREATE VIEW view_cost AS\n" +
                "SELECT title,cost FROM products WHERE cost<="+maxPrice);
        rs=stmt.executeQuery("SELECT title,cost FROM view_cost WHERE cost>="+minPrice);
        System.out.println("title          cost");
        while (rs.next()){
            System.out.println(rs.getString("title")+"          "+rs.getInt("cost"));
        }
        stmt.execute("DROP VIEW view_cost");
    }

    private static void changePrice(String title, String newPrice) throws SQLException {
        int bl=stmt.executeUpdate("UPDATE products SET cost='"+newPrice+"' WHERE title = '"+title+"'");
        if (bl!=0){
            System.out.println("Стоимость "+title+" была изменена на "+newPrice);
        }else {
            System.out.println("Такого товара нет");
        }
    }

    private static void printPrice(String title) throws SQLException {
       rs=stmt.executeQuery("SELECT cost FROM products WHERE title = '"+title+"'");
       if(rs.next()){
           System.out.println("Цена товара "+title+": "+rs.getInt(1));
       }else {
           System.out.println("Такого товара нет");
       }
    }

    private static void createTableProduct() throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS products (\n" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "prodid INTEGER UNIQUE,\n" +
                "title TEXT,\n" +
                "cost INT)");
    }

    //Метод подключения к БД
    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt=connection.createStatement();
    }

    //Метод отключения от БД
    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
