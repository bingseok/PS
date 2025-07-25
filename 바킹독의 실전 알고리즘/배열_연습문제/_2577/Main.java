package 배열_연습문제._2577;

import java.util.*;

public class Main {
    public int[] solution(int a, int b, int c) {
        int[] answer = new int[10];

        int res = a * b * c;
        while (res != 0) {
            answer[res % 10]++;
            res /= 10;
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int a, b, c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        for (int x : T.solution(a, b, c)) System.out.println(x);
    }
}
