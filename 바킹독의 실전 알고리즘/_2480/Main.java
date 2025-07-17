package _2480;

import java.util.*;

public class Main {
    public int solution(int[] arr) {
        int answer = 0;
        if (arr[0] == arr[2]) answer = 10000 + arr[0] * 1000;
        else if (arr[0] == arr[1] || arr[1] == arr[2]) answer = 1000 + arr[0] * 100;
        else answer = arr[2] * 100;

        return answer;
    }

    public static void main(String[] arg) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        System.out.print(T.solution(arr));
    }
}
