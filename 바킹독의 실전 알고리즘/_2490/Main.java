package _2490;

import java.util.Scanner;

public class Main {
    public static String answer = "DCBAE";
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            int result = 0;
            for (int j = 0; j < 4; j++) {
                result += sc.nextInt();
            }
            System.out.println(answer.charAt(result));
        }
    }
}
