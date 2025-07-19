package C1._10093;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a, b;
        a = sc.nextLong();
        b = sc.nextLong();

        if (a > b) {
            long tmp = a;
            a = b;
            b = tmp;
        }

        if (a == b || b - a == 1) System.out.println("0");
        else {
            System.out.println(b - a - 1);
            for (long i = a + 1; i < b; i++)
                System.out.print(i + " ");
        }
    }
}
