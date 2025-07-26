package 스택_연습문제._2493;

import java.util.*;
import java.io.*;

public class Main {

    public static class Tower {
        int index;
        int height;
        public Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer heights = new StringTokenizer(br.readLine());

        Stack<Tower> st = new Stack<>();
        st.push(new Tower(0, 100000005));

        for (int i = 1; i <= n; i++) {
            int k = Integer.parseInt(heights.nextToken());
            while (st.peek().height < k) st.pop();
            answer.append(st.peek().index).append(" ");
            st.push(new Tower(i, k));
        }

        System.out.print(answer);
    }
}
