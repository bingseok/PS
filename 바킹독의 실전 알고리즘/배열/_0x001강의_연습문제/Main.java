package 배열._0x001강의_연습문제;

import java.util.*;
import java.io.*;

public class Main {
    static int[] board = new int[101];

    public static void main(String[] args) throws IOException {
        System.out.print(func2(new int[]{1, 52, 48}, 3));
        System.out.print(func2(new int[]{50, 42}, 2));
        System.out.print(func2(new int[]{4, 13, 63, 87}, 4));
    }

    static int func2(int[] arr, int len) {
        Arrays.fill(board, 0);
        for (int x : arr) {
            if (board[100-x] == 1) return 1;
            board[x] = 1;
        }
        return 0;
    }
}
