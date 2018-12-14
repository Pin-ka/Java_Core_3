package Lesson_7.BasicAnnotation;

public class Tests {
    @BeforeSuite
    public static void before() {
        System.out.println("Начало тестирования");
    }
    @AfterSuite
    public static void after() {
        System.out.println("Конец тестирования");
    }
    @Test(priority = 4)
    public static  void test6() {
        System.out.println("Выполнение теста 6");
    }
    @Test(priority = 8)
    public static  void test2() {
        System.out.println("Выполнение теста 2");
    }
    @Test(priority = 3)
    public static  void test7() {
        System.out.println("Выполнение теста 7");
    }
    @Test(priority = 6)
    public static  void test4() {
        System.out.println("Выполнение теста 4");
    }
    @Test(priority = 9)
    public static  void test1() {
        System.out.println("Выполнение теста 1");
    }
    @Test(priority = 2)
    public static  void test8() {
        System.out.println("Выполнение теста 8");
    }
    @Test
    public static  void dop_test1() {
        System.out.println("Выполнение дополнительного теста 1 - без приоритета");
    }
    @Test(priority = 5)
    public static  void test5() {
        System.out.println("Выполнение теста 5");
    }
    @Test(priority = 7)
    public static  void test3() {
        System.out.println("Выполнение теста 3");
    }
    @Test
    public static  void dop_test2() {
        System.out.println("Выполнение дополнительного теста 2 - без приоритета");
    }

}
