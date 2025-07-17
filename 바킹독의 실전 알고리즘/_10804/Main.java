package _10804;

import java.util.*;

public class Main {
    static int[] board = new int[21];

    public void reverse(int a, int b) {
        int lt = a, rt = b;
        while (lt < rt) {
            int tmp = board[lt];
            board[lt] = board[rt];
            board[rt] = tmp;
            lt++; rt--;
        }
    }
    public static void main(String[] arg) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 20; i++) board[i] = i;
        for (int i = 0; i < 10; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            T.reverse(a, b);
        }
        for (int i = 1; i <= 20; i++) System.out.print(board[i] + " ");
    }
}

