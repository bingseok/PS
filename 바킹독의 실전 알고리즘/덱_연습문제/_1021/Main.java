package 덱_연습문제._1021;

import java.util.*;
import java.io.*;

public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int answer = 0;
//        Deque<Integer> dq = new LinkedList<>();
//        String[] s = br.readLine().split(" ");
//        int n = Integer.parseInt(s[0]);
//        int m = Integer.parseInt(s[1]);
//        int[] num = new int[m];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < m; i++) {
//            num[i] = Integer.parseInt(st.nextToken());
//        }
//
//        for (int i = 1; i <= n; i++) dq.addLast(i);
//
//        int size = n;
//        for (int i = 0; i < m; i++, size--) {
//            // 1 2 3 4 5 6 7 8
//            int lt = 0, rt = 0;
//            Iterator<Integer> it = dq.iterator();
//            while (it.hasNext()) {
//                Integer tmp = it.next();
//                if (tmp == num[i]) break;
//                lt++;
//            }
//            rt = size - lt;
//            if (lt <= rt) {
//                while (dq.peekFirst() != num[i]) {
//                    dq.addLast(dq.peekFirst());
//                    dq.removeFirst();
//                    answer++;
//                }
//                dq.removeFirst();
//            }
//            else {
//                while (dq.peekFirst() != num[i]) {
//                    dq.addFirst(dq.peekLast());
//                    dq.removeLast();
//                    answer++;
//                }
//                dq.removeFirst();
//            }
//        }
//
//        System.out.print(answer);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new LinkedList<>();
        String[] s = br.readLine().split(" ");
        int answer = 0;
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);

        for (int i = 1; i <= n; i++) dq.addLast(i);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(st.nextToken());
            Iterator<Integer> it = dq.iterator();
            int idx = 0;
            while (it.hasNext()) {
                if (it.next() == k) break;
                idx++;
            }
            while (dq.peekFirst() != k) {
                // 1 2 3 4 5 6 7 8
                if (idx <= dq.size() - idx) {
                    dq.addLast(dq.peekFirst());
                    dq.removeFirst();
                    answer++;
                }
                else {
                    dq.addFirst(dq.peekLast());
                    dq.removeLast();
                    answer++;
                }
            }
            dq.removeFirst();
        }
        System.out.print(answer);
    }
}
