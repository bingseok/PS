package _2576;

import java.util.*;

public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[7];
        for (int i = 0; i < 7; i++) arr[i] = sc.nextInt();
        int odd = 0, sum = 0, min = 100;
        for (int i = 0; i < 7; i++) {
            if (arr[i] % 2 == 1) {
                odd++;
                sum += arr[i];
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
        }

        if (odd == 0) System.out.print(-1);
        else {
            System.out.print(sum + "\n" + min);
        }
    }
}
