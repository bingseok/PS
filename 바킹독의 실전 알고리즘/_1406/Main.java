package _1406;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        LinkedList<Character> list = new LinkedList<>();

        String input = br.readLine();
        for (char c : input.toCharArray()) list.add(c);
        ListIterator<Character> cursor = list.listIterator(list.size());

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] cmd = br.readLine().split(" ");
            switch (cmd[0]) {
                case "L":
                    if (cursor.hasPrevious()) cursor.previous();
                    break;
                case "D":
                    if (cursor.hasNext()) cursor.next();
                    break;
                case "B":
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                case "P" :
                    cursor.add(cmd[1].charAt(0));
            }
        }

        for (char c : list) answer.append(c);
        System.out.print(answer);

    }
}
