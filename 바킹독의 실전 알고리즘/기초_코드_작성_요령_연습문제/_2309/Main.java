package 기초_코드_작성_요령_연습문제._2309;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        sum -= 100;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    for (int k = 0; k < arr.length; k++) {
                        if (k == i || k == j) continue;
                        System.out.println(arr[k]);
                    }
                }
            }
        }
    }
}
