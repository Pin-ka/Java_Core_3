package Lesson_6;

import java.util.ArrayList;
import java.util.Collections;


public class AfterLastFour {
    public static Integer[] aboardAfterLastFour(int[] arr) throws RuntimeException {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) break;
            result.add(arr[i]);
        }

        if (result.size() == arr.length) throw new RuntimeException();

        Collections.reverse(result);
        Integer[] resultArr=result.toArray(new Integer[result.size()]);
        return resultArr;
    }

}

