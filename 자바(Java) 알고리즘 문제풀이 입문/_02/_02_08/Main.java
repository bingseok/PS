package _02._02_08;

import java.util.Scanner;

public class Main {

    public int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int res = 1;
            int x = arr[i];
            for (int j = 0 ; j < n; j++) {
                if (arr[j] > x) res++;
            }
            answer[i] = res;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        for (int x : T.solution(n, arr))
            System.out.print(x + " ");
    }
}
