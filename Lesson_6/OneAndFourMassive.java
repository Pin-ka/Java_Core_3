package Lesson_6;

public class OneAndFourMassive {
    public static boolean isItOneAndFour(int[] arr){
        int countOne=0;
        int countFour=0;
        for (int i=0;i<arr.length;i++){
            if ((arr[i]!=1)&&(arr[i]!=0)){
                return false;
            }
            if (arr[i]==1){
                countOne++;
            }
            if (arr[i]==4){
                countFour++;
            }
        }
        if (countOne==0||countFour==0){
            return false;
        }else {
            return true;
        }
    }
}
