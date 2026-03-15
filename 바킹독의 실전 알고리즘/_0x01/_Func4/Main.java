package _0x01._Func4;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(func4(5));
        System.out.println(func4(97615282));
        System.out.println(func4(1024));
    }

    static int func4(int n) {
        int cur = 2;
        while (2 * cur <= n) {
            cur *= 2;
        }

        return cur;
    }
}
