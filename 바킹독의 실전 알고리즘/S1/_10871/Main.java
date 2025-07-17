package S1._10871;

import java.util.Scanner;

public class Main {
    public void solution(int n, int x, int[] arr) {
        for (int k : arr) {
            if (k < x) System.out.print(k + " ");
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n, x;
        n = sc.nextInt();
        x = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        T.solution(n, x, arr);
    }
}
