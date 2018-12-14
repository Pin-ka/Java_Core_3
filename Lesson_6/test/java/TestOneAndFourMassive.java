import Lesson_6.OneAndFourMassive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class TestOneAndFourMassive {
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        int[]arr1={1, 1, 4, 1};
        int[]arr2={4, 4, 4};
        int arr3[]={1, 1, 1};
        int arr4[]={11, 44};
        List<Object[]> objects = Arrays.asList(new Object[][]{
                {arr1, true},
                {arr2, false},
                {arr3, false},
                {arr4, false},
        });
        return objects;
    }
    private int[] arr;
    private boolean result;

    public TestOneAndFourMassive (int[]arr,boolean result){
        this.arr=arr;
        this.result=result;
    }

    OneAndFourMassive oneAndFourMassive;

    @Before
    public void init(){
        oneAndFourMassive=new OneAndFourMassive();
    }

    @Test
    public void test1and4(){
        Assert.assertEquals(oneAndFourMassive.isItOneAndFour(arr), result);
    }
}
