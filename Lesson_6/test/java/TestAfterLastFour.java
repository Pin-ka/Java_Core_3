import Lesson_6.AfterLastFour;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestAfterLastFour {
    AfterLastFour alf;

    @Before
    public void init(){
        alf=new AfterLastFour();
    }
    @Test
    public void test1(){
        int [] sourse = {1,2,3,4,5,6,7};
        Integer[] result = {5,6,7};
        Assert.assertArrayEquals(result, alf.aboardAfterLastFour(sourse));
    }
    @Test
    public void test2(){
        int [] sourse = {1,2,3,4};
        Integer[] result = {};
        Assert.assertArrayEquals(result, alf.aboardAfterLastFour(sourse));
    }
    @Test(expected = RuntimeException.class)
    public void test3(){
        int [] sourse = {1,2,3};
        alf.aboardAfterLastFour(sourse);
    }

    @After
    public void shutdown(){
        System.out.println("end");
    }
}
