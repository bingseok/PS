package _02_01;

import java.util.*;
public class Main {

    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) answer.add(arr[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        arr[0] = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int c : T.solution(n, arr)) {
            System.out.print(c + " ");
        }
    }
}
