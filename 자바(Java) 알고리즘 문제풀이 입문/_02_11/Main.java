package _02_11;

import java.util.*;

public class Main {

    public int solution(int n, int[][] arr) {
        int answer = 1;
        int mx = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                for (int k = 0; k < 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt > mx) {
                mx = cnt;
                answer = i+1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][5];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 5; j++)
                arr[i][j] = sc.nextInt();

        System.out.print(T.solution(n, arr));
    }
}
