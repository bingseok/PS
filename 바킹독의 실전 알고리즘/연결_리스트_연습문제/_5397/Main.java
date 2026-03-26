package 연결_리스트_연습문제._5397;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static LinkedList<Character> list = new LinkedList<>();
    static int t;
    static String op;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            list.clear();
            ListIterator cursor = list.listIterator();
            op = br.readLine();
            for (char c : op.toCharArray()) {
                if (c == '<') {
                    if (cursor.hasPrevious()) cursor.previous();
                }
                else if (c == '>') {
                    if (cursor.hasNext()) cursor.next();
                }
                else if (c == '-') {
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                }
                else {
                    cursor.add(c);
                }
            }

            for (char c : list) sb.append(c);
            sb.append("\n");
        }
        System.out.print(sb);
    }

}
