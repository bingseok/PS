package _0x01._Func3;

import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        System.out.println(func3(9));
        System.out.println(func3(693953651));
        System.out.println(func3(756580036));
    }

    static int func3(int n) {
        int cur = 1;
        while (cur * cur <= n) {
            if (cur * cur == n) return 1;
            else cur++;
        }
        return 0;
    }
}
