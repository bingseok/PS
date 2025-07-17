package S1.P3;

import java.util.Scanner;

public class Main {
    public boolean solution(int n) {
        boolean answer = false;

        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) return true;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(T.solution(n));
    }
}
