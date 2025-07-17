package _2562;

import java.util.*;

public class Main {

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int mx = 1, mv = sc.nextInt();
        for (int i = 2; i <= 9; i++) {
            int tmp = sc.nextInt();
            if (tmp > mv) {
                mx = i;
                mv = tmp;
            }
        }
        System.out.print(mv + "\n" + mx);
    }
}
