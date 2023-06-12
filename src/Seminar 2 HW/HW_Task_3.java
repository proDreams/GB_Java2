//Написать функцию, возвращающую истину, если в переданном массиве есть два соседних элемента, с нулевым значением.

public class HW_Task_3 {
    public static void main(String[] args) {
        int[] res = {2, 1, 2, 3, 0, 4};
        System.out.println(zeroFinder(res));
    }

    public static boolean zeroFinder(int[] arr) {
        boolean zero = false;
        for (int i : arr) {
            if (i == 0) {
                if (zero) {
                    return true;
                } else {
                    zero = true;
                }
            }
        }
        return false;
    }
}
