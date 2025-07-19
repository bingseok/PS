package C3._10808;

import java.util.*;

public class Main {
    public static int[] board = new int[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();

        for (char c : n.toCharArray()) {
            board[c - 'a']++;
        }

        for (int x : board) System.out.print(x + " ");
    }
}
