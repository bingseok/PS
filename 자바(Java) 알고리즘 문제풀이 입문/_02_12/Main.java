package _02_12;

import java.util.Scanner;

public class Main {
    public int solution(int n, int m, int[][] arr) {
        int answer = 0;
        // n : 학생 수, m : 수학 성적의 개수

        int[][] rank = new int[m][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rank[i][arr[i][j]] = j + 1;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                boolean isMento = true;
                for (int k = 0; k < m; k++) {
                    if (rank[k][i] > rank[k][j]) {
                        isMento = false;
                        break;
                    }
                }
                if (isMento) answer++;
            }
        }
        return answer;
    }

    public int solution2(int n, int m, int[][] arr) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = 0;
                for (int k = 0; k < m; k++) {
                    int pi = 0, pj = 0;
                    for (int l = 0; l < n; l++) {
                        if (arr[k][l] == i) pi = l;
                        if (arr[k][l] == j) pj = l;
                    }
                    if (pi < pj) cnt++;
                }
                if (cnt == m) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        System.out.print(T.solution2(n, m, arr));
    }
}
