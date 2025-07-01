package _02_03;

import java.util.*;

public class Main {
    public ArrayList<String> solution(int n, int[] a, int[] b) {
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) answer.add("D");
            else if (a[i] == 1) {
                if (b[i] == 2) answer.add("B");
                else answer.add("A");
            }
            else if (a[i] == 2) {
                if (b[i] == 1) answer.add("A");
                else answer.add("B");
            }
            else if (a[i] == 3) {
                if (b[i] == 2) answer.add("A");
                else answer.add("B");
            }
        }
        return answer;
    }

    public ArrayList<String> solution2(int n, int[] a, int[] b) {
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) answer.add("D");
            else if (a[i] == 1 && b[i] == 3) {
                answer.add("A");
            }
            else if (a[i] == 2 && b[i] == 1) {
                answer.add("A");
            }
            else if (a[i] == 3 && b[i] == 2) {
                answer.add("A");
            }
            else answer.add("B");
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            b[i] = sc.nextInt();
        for (String x : T.solution(n, a, b))
            System.out.println(x);
    }

}
