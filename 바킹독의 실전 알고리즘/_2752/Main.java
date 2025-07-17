package _2752;

import java.util.*;

public class Main {
    public int[] solution(int[] arr) {
        int[] answer = arr;
        Arrays.sort(arr);
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) arr[i] = sc.nextInt();
        for (int x : T.solution(arr)) System.out.print(x + " ");
    }
}
