package 덱_연습문제._5430;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_list {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static void parse(List<Integer> list, String arr) {
        int res = 0;
        for (int i = 1; i < arr.length() - 1; i++) {
            if (arr.charAt(i) == ',') {
                list.add(res);
                res = 0;
            }
            else res = res * 10 + (arr.charAt(i) - '0');
        }
        if (res != 0) list.add(res);
    }

    static void append_sb(List<Integer> list) {
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) sb.append(",");
        }
        sb.append("]\n");

    }
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            List<Integer> list = new ArrayList<>();
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            parse(list, arr);

            boolean rev = false;
            int lt = 0, rt = n;
            for (char x : p.toCharArray()) {
                if (x == 'R') rev = !rev;
                else {
                    if (rev) rt--;
                    else lt++;
                }
            }

            if (lt > rt) sb.append("error\n");
            else {
                list = list.subList(lt, rt);
                if (rev) Collections.reverse(list);
                append_sb(list);
            }
        }
        System.out.print(sb);
    }
}
