package C1._1000;

import java.util.*;

public class Main {
    public int solution(int a, int b) {
        int answer = 0;
        answer = a + b;
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); int b = sc.nextInt();
        System.out.print(T.solution(a, b));
    }
}
