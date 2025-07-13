package _02._02_09;

import java.util.Scanner;

public class Main {
    public int solution(int n, int[][] arr) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int res1 = 0, res2 = 0;
            for (int j = 0; j < n; j++) {
                res1 += arr[i][j];
                res2 += arr[j][i];
            }
            int res = Math.max(res1, res2);
            answer = Math.max(answer, res);
        }

        int res1 = 0, res2 = 0;
        for (int i = 0; i < n; i++) {
            res1 += arr[i][i];
            res2 += arr[i][n-i-1];
        }

        int res = Math.max(res1, res2);
        answer = Math.max(answer, res);
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        }
        System.out.print(T.solution(n, arr));
    }
}
