package 큐_연습문제._2164;

import java.util.*;
import java.io.*;

public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Queue<Integer> Q = new LinkedList<>();
//        int n = Integer.parseInt(br.readLine());
//        int answer = 1;
//        for (int i = 1; i <= n; i++) Q.add(i);
//
//        if (n == 1) System.out.print(answer);
//        else {
//            while (true) {
//                Q.remove();
//                if (Q.size() == 1) {
//                    answer = Q.peek();
//                    break;
//                }
//                Q.add(Q.peek());
//                Q.remove();
//            }
//            System.out.print(answer);
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= n; i++) Q.add(i);

        while (Q.size() != 1) {
            Q.remove();
            Q.add(Q.peek());
            Q.remove();
        }
        System.out.print(Q.peek());
    }
}
