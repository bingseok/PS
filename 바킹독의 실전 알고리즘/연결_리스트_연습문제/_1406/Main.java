package 연결_리스트_연습문제._1406;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static LinkedList<Character> list = new LinkedList<>();
    static String input;
    static int m;

    public static void main(String[] args) throws IOException {
        input = br.readLine();
        for (char c : input.toCharArray()) {
            list.add(c);
        }
        ListIterator cursor = list.listIterator(list.size());
        m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if (op.equals("L")) {
                if (cursor.hasPrevious()) cursor.previous();
            }
            else if (op.equals("D")) {
                if (cursor.hasNext()) cursor.next();
            }
            else if (op.equals("B")) {
                if (cursor.hasPrevious()) {
                    cursor.previous();
                    cursor.remove();
                }
            }
            else if (op.equals("P")) {
                char c = st.nextToken().charAt(0);
                cursor.add(c);
            }
        }

        for (char c : list)
            sb.append(c);
        System.out.print(sb);
    }

}
