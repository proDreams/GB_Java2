// 2. Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3], и представляют собой,
// например, состояния ячеек поля для игры в крестики-нолики,
// где 0 – это пустое поле, 1 – это поле с крестиком, 2 – это поле с ноликом, 3 – резервное значение.
// Такое предположение позволит хранить в одном числе типа int всё поле 3х3.
// Записать в файл 9 значений так, чтобы они заняли три байта.
//
// 3 (*) - В продолжение 2 дописать "разворачивание" поля игры крестики-нолики из сохраненного в файле состояния
// (распарсить файл, в зависимости от значений (0-3) нарисовать поле со значками 'х' 'о' '.'

import java.io.*;
import java.util.Arrays;

public class main_6 {
    public static void main(String[] args) throws IOException {
        int[] xoRows = new int[]{000, 000, 000};
        int[] converted = new int[3];
        byte[] xoData = new byte[3];

        for (int i = 0; i < xoRows.length; i++) {
            converted[i] = convert_to_fourth(xoRows[i]);
        }

        for (int j = 0; j < converted.length; j++) {
            xoData[j] = (byte) converted[j];
        }
        try (FileOutputStream fos = new FileOutputStream("xo.bin")) {
            fos.write(xoData);
        }

        int[] board = new int[3];
        File xo = new File("xo.bin");
        try (InputStream inStream = new FileInputStream(xo)) {
            int i = 0;
            for (byte s : inStream.readAllBytes()) {
                board[i] = convert_to_dec(Integer.parseInt(String.valueOf(s)));
                i++;
            }
        }

        printBoard(board);
    }

    private static int convert_to_fourth(int value) {
        return Integer.parseInt(String.valueOf((int) (value / 100 * Math.pow(4, 2) + value / 10 % 10 * Math.pow(4, 1) + value % 10 * Math.pow(4, 0))));
    }

    private static int convert_to_dec(int value) {
        StringBuilder res = new StringBuilder();
        while (value > 0) {
            res.append(value % 4);
            value = value / 4;
        }
        return Integer.parseInt(res.reverse().toString());
    }

    private static void printBoard(int[] board) {
        for (int r : board) {
            int[] row = new int[]{r / 100, r / 10 % 10, r % 10};
            System.out.print("|");
            for (int i : row) {
                if (i == 0) {
                    System.out.print(" |");
                } else if (i == 1) {
                    System.out.print("x|");
                } else if (i == 2) {
                    System.out.print("0|");
                } else if (i == 3) {
                    System.out.print("?|");
                }
            }
            System.out.print("\n");
        }
    }
}
