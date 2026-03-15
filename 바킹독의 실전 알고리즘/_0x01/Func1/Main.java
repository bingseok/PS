package _0x01.Func1;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(func1(16));
        System.out.println(func1(34567));
        System.out.println(func1(27639));
    }

    static int func1(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0) sum += i;
        }

        return sum;
    }
}



