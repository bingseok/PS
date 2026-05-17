package _백트래킹.next_permutation;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 1. next_permutation
        int[] a = {1, 2, 3, 4};

        Arrays.sort(a);

        do {
            for (int i: a) System.out.print(i+ " ");
            System.out.println();
        } while (next_permutation(a));

        System.out.println("----------");
        // 1 2 3 4 중 수 2개를 순서 없이 뽑는 모든 경우 출력
        a = new int[]{0, 0, 1, 1};
        do {
            for (int i = 0; i < 4; i++) {
                if (a[i] == 0) System.out.print(i+1 + " ");
            }
            System.out.println();
        } while (next_permutation(a));
    }

    static boolean next_permutation(int[] a) {
        if (a.length <= 1) return false;

        // 1. 뒤에서부터 a[i] < a[i+1]인 인덱스 찾기
        int i = a.length - 2;

        while (i >= 0 && a[i] >= a[i+1]) i--;

        // 마지막 순열인 경우
        if (i < 0) return false;

        // 2. 뒤에서부터 a[i]보다 큰 값 찾기
        int j = a.length - 1;
        while (a[i] >= a[j]) j--;

        swap(a, i, j);

        // 4. 뒤쪽 뒤집기 (reverse)
        int left = i + 1;
        int right = a.length - 1;
        while (left < right) swap(a, left++, right--);

        return true;
    }

    static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
