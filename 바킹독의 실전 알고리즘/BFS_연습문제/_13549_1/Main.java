package BFS_연습문제._13549_1;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static final int MX = 100001;
    static int[] board = new int[MX + 2];
    static Deque<Integer> DQ = new ArrayDeque<>();
    static int n, k;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board[n] = 1;
        DQ.addFirst(n);

        while (board[k] == 0) {
            int cur = DQ.peekFirst(); DQ.removeFirst();
            int[] dx = {cur-1, cur+1, 2*cur};
            for (int x : dx) {
                if (x < 0 || x >= MX) continue;
                if (board[x] != 0) continue;
                if (x == 2*cur) {
                    board[x] = board[cur];
                    DQ.addFirst(x);
                }
                else {
                    board[x] = board[cur] + 1;
                    DQ.addLast(x);
                }
            }
        }

        System.out.print(board[k] - 1);
    }


}
