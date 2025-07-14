package _03_04;

import java.util.*;

public class Main {
    public int solution(int n, int m, int[] arr) {
        int answer = 0, sum = 0, lt = 0;

        // right는 0 ~ n-1까지
        for (int rt = 0; rt < n; rt++) {
            // left ~ right까지의 합을 구하고
            sum += arr[rt];
            // 그 합이 m인지 확인, m이면 answer를 증가
            if (sum == m) answer++;

            // sum이 m보다 크거나 같으면 while문 실행
            // lt를 1씩 증가시키면서 sum에서 값을 빼주는데,
            // sum == m 일 경우에도 lt는 1 증가 시켜줘야함
            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m) answer++;
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
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.print(T.solution(n, m, arr));

    }
}
