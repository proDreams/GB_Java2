//Написать функцию, возвращающую разницу между самым большим и самым маленьким элементами переданного не пустого массива.

public class HW_Task_2 {
    public static void main(String[] args) {
        int[] res = {2, 1, 2, 3, 4};
        System.out.println(minMax(res));
    }

    public static int minMax(int[] arr){
        int min = arr.length;
        int max = 0;
        for (int i : arr){
            if (i > max){
                max = i;
            } else if (i < min){
                min = i;
            }
        }
        return max - min;
    }
}
