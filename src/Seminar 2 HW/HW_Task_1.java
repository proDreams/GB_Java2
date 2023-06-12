//Написать метод, возвращающий количество чётных элементов массива.
// countEvens([2, 1, 2, 3, 4]) → 3 countEvens([2, 2, 0]) → 3 countEvens([1, 3, 5]) → 0

public class HW_Task_1 {
    public static void main(String[] args) {
        int[] res = {2, 2, 0};
        System.out.println(countEvens(res));
    }

    public static int countEvens(int[] arr){
        int count = 0;
        for (int i : arr){
            if (i % 2 == 0){
                count++;
            }
        }
        return count;
    }
}
