package _02_06;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    public ArrayList<Integer> solution(int n, String[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String tmp = new StringBuilder(arr[i]).reverse().toString();
            int key = Integer.parseInt(tmp);
            boolean isPrime = true;
            if (key == 1) isPrime = false;
            for (int j = 2; j <= Math.sqrt(key); j++) {
                if (key % j == 0) isPrime = false;
            }
            if (isPrime) answer.add(key);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main1 T = new Main1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) arr[i] = sc.next();
        for (int x : T.solution(n, arr)) System.out.print(x + " ");
    }
}
