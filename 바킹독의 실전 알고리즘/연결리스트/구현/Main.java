package 연결리스트.구현;

import java.util.*;
import java.io.*;

public class Main {
    final static int MX = 1000005;
    static int[] dat = new int[MX];
    static int[] pre = new int[MX];
    static int[] nxt = new int[MX];
    static int unused = 1;

    public static void main(String[] args) {

    }

    static void insert(int addr, int num) {
        dat[unused] = num;
        pre[unused] = addr;
        nxt[unused] = nxt[addr];
        if (nxt[addr] != -1) pre[nxt[addr]] = unused;
        nxt[addr] = unused;
        unused++;
    }

    static void erase(int addr) {
        nxt[pre[addr]] = nxt[addr];
        if (nxt[addr] != -1) pre[nxt[addr]] = pre[addr];
    }

    static void traverse() {
        int cur = nxt[0];
        while (cur != -1) {
            System.out.print(dat[cur] + " ");
            cur = nxt[cur];
        }
        System.out.println();
    }
}
