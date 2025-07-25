package _5397;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringBuilder answer = new StringBuilder();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> cursor = list.listIterator(list.size());
            String input = br.readLine();
            for (char c : input.toCharArray()) {
                if (c == '<') {
                    if (cursor.hasPrevious())
                        cursor.previous();
                }
                else if (c == '>') {
                    if (cursor.hasNext())
                        cursor.next();
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
            for (char c : list) answer.append(c);
            System.out.println(answer);
        }
    }
}
