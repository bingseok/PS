package _03_01;

import java.util.*;

public class Main {
    public ArrayList<Integer> solution(int n, int[] arr1, int m, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();

        int p1 = 0, p2 = 0;
        while (answer.size() != n + m) {
            if (p1 == n) answer.add(arr2[p2++]);
            else if (p2 == m) answer.add(arr1[p1++]);
            else {
                if (arr1[p1] <= arr2[p2])
                    answer.add(arr1[p1++]);
                else answer.add(arr2[p2++]);
            }
        }
        return answer;
    }

    public ArrayList<Integer> solution(int n, int m, int[] arr1, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (arr1[p1] < arr2[p2]) answer.add(arr1[p1++]);
            else answer.add(arr2[p2++]);
        }
        while (p1 < n) answer.add(arr1[p1++]);
        while (p2 < m) answer.add(arr2[p2++]);

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) arr1[i] = sc.nextInt();
        m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) arr2[i] = sc.nextInt();
        for (int x : T.solution(n, arr1, m, arr2))
            System.out.print(x + " ");
    }

}
