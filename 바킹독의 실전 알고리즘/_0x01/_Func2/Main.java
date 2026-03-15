package _0x01._Func2;

import java.util.*;
import java.io.*;

public class Main {
    static int[] vis = new int[101];

    public static void main(String[] args) throws IOException {
        System.out.println(func2(new int[]{1, 52, 48}, 3));
        System.out.println(func2(new int[]{50, 42}, 2));
        System.out.println(func2(new int[]{4, 13, 63, 87}, 4));
    }

    static int func2(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int cnt = arr[i];
            if (vis[100-cnt] == 1) return 1;
            else vis[cnt] = 1;
        }

        Arrays.fill(vis, 0);
        return 0;
    }
}
